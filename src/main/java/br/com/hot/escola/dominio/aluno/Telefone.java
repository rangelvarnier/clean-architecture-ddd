package br.com.hot.escola.dominio.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if (ddd == null
                || numero == null
                || !ddd.matches("\\d{2}")
                || !numero.matches("\\d{4,5}\\-\\d{4}")) {
            throw new IllegalArgumentException("Telefone invalido!");
        }
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
