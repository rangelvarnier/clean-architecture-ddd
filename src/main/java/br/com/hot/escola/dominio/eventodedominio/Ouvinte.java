package br.com.hot.escola.dominio.eventodedominio;

public abstract class Ouvinte {
    
    public void processar(Evento evento){
        if(deveProcessar(evento)){
            reageAo(evento);
        }
    }

    protected abstract void reageAo(Evento evento);

    protected abstract boolean deveProcessar(Evento evento);
}
