package service;

import java.io.*;
import java.net.*;
import pojo.Candidato;
import java.util.List;

public class VotingMulticast {
    public static void main(String[] args) throws IOException {
        InetAddress grupo = InetAddress.getByName("230.0.0.1");
        int porta = 12346;

        MulticastSocket socket = new MulticastSocket();

        System.out.println("Servidor multicast de votação iniciado...");

        while (true) {
            List<Candidato> candidatos = VotingServer.getCandidatos();
            StringBuilder resultado = new StringBuilder("Resultado parcial:\n");
            for (Candidato c : candidatos) {
                resultado.append(c.toString()).append("\n");
            }

            byte[] dados = resultado.toString().getBytes();
            DatagramPacket pacote = new DatagramPacket(dados, dados.length, grupo, porta);
            socket.send(pacote);

            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
