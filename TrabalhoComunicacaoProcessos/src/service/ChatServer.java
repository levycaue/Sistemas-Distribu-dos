package service;

import java.io.*;
import java.net.*;
import pojo.Mensagem;

public class ChatServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Servidor iniciado na porta 12345...");

        while (true) {
            Socket cliente = server.accept();
            System.out.println("Cliente conectado: " + cliente.getInetAddress());

            // Streams para objetos
            ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());

            // Recebe objeto Mensagem
            Mensagem mensagem = (Mensagem) in.readObject();
            System.out.println("Recebido: " + mensagem.getTexto());

            // Cria resposta e envia de volta
            Mensagem resposta = new Mensagem("Servidor recebeu: " + mensagem.getTexto());
            out.writeObject(resposta);

            cliente.close();
        }
    }
}
