package pojo;

import java.io.Serializable;

public class Mensagem implements Serializable {
    private String texto;
    private long timestamp;

    public Mensagem(String texto) {
        this.texto = texto;
        this.timestamp = System.currentTimeMillis();
    }

    public String getTexto() {
        return texto;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + texto;
    }
}
