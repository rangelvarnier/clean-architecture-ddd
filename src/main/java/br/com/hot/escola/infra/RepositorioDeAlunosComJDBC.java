package br.com.hot.escola.infra;

import br.com.hot.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.hot.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "insert into aluno values(?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "insert into telefone values(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone: aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try {
            String sql = "select id, nome, email from aluno where cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet resultSet = ps.executeQuery();
            if(!resultSet.next()){
                throw new AlunoNaoEncontrado(cpf);
            }

            String nome = resultSet.getString("nome");
            Email email = new Email(resultSet.getString("email"));
            Aluno aluno = new Aluno(cpf, nome, email);

            Long id = resultSet.getLong("id");
            sql = "select ddd, numero from telefone where aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                String ddd = resultSet.getString("ddd");
                String numero = resultSet.getString("numero");
                aluno.adicionarTelefone(ddd, numero);
            }

            return aluno;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try {
            String sql = "select id, nome, email from aluno";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();

            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = rs.getLong("id");
                sql = "select ddd, numero from telefone where aluno_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                psTelefone.setLong(1, id);

                ResultSet rsTelefone = psTelefone.executeQuery();
                while (rsTelefone.next()) {
                    String ddd = rsTelefone.getString("ddd");
                    String numero = rsTelefone.getString("numero");
                    aluno.adicionarTelefone(ddd, numero);
                }
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
