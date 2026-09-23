package service;

import java.io.*;
import java.net.*;

public class MulticastClient {
    public static void main(String[] args) throws IOException {
        InetAddress grupo = InetAddress.getByName("230.0.0.1"); // mesmo endereço multicast
        int porta = 12345;

        MulticastSocket socket = new MulticastSocket(porta);
        socket.joinGroup(grupo);

        System.out.println("Cliente multicast conectado. Aguardando mensagens...");

        byte[] buffer = new byte[1024];
        while (true) {
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
            socket.receive(pacote);

            String mensagem = new String(pacote.getData(), 0, pacote.getLength());
            System.out.println("Recebido: " + mensagem);
        }
    }
}
