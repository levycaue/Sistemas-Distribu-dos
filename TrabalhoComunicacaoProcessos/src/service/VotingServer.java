package service;

import java.io.*;
import java.net.*;
import java.util.*;
import pojo.Candidato;

public class VotingServer {
    private static List<Candidato> candidatos = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        candidatos.add(new Candidato("Alice", 1));
        candidatos.add(new Candidato("Bob", 2));
        candidatos.add(new Candidato("Carlos", 3));

        ServerSocket server = new ServerSocket(12345);
        System.out.println("Servidor de votação iniciado...");

        while (true) {
            Socket cliente = server.accept();
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());

            int numeroVoto = (int) in.readObject();
            Optional<Candidato> candidato = candidatos.stream()
                    .filter(c -> c.getNumero() == numeroVoto)
                    .findFirst();

            if (candidato.isPresent()) {
                candidato.get().adicionarVoto();
                out.writeObject("Voto registrado para " + candidato.get().getNome());
            } else {
                out.writeObject("Candidato inválido!");
            }

            cliente.close();
        }
    }

    public static List<Candidato> getCandidatos() {
        return candidatos;
    }
}
