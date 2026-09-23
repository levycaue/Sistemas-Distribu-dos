package service;

import java.io.*;
import java.net.*;

public class MulticastServer {
    public static void main(String[] args) throws IOException {
        InetAddress grupo = InetAddress.getByName("230.0.0.1");
        int porta = 12345;

        MulticastSocket socket = new MulticastSocket();
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Servidor multicast iniciado. Digite mensagens para enviar:");

        String mensagem;
        while ((mensagem = teclado.readLine()) != null) {
            byte[] dados = mensagem.getBytes();
            DatagramPacket pacote = new DatagramPacket(dados, dados.length, grupo, porta);
            socket.send(pacote);
            System.out.println("Mensagem enviada: " + mensagem);
        }
    }
}
