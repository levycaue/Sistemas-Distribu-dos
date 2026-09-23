package pojo;

import java.io.Serializable;

public class Candidato implements Serializable {
    private String nome;
    private int numero;
    private int votos;

    public Candidato(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.votos = 0;
    }

    public String getNome() { return nome; }
    public int getNumero() { return numero; }
    public int getVotos() { return votos; }

    public void adicionarVoto() { votos++; }

    @Override
    public String toString() {
        return numero + " - " + nome + " (votos: " + votos + ")";
    }
}
