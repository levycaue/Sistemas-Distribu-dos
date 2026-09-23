package service;

import java.io.*;
import java.net.*;
import pojo.Mensagem;

public class ChatClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 12345);

        // Streams para objetos
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        // Cria e envia objeto Mensagem
        Mensagem mensagem = new Mensagem("Olá, servidor! Esta é uma mensagem serializada.");
        out.writeObject(mensagem);

        // Recebe resposta do servidor
        Mensagem resposta = (Mensagem) in.readObject();
        System.out.println("Servidor respondeu: " + resposta.getTexto());

        socket.close();
    }
}
