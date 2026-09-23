package service;

import java.io.*;
import java.net.*;
import pojo.Mensagem;

public class ChatClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 12345);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        Mensagem mensagem = new Mensagem("Olá, servidor! Esta é uma mensagem serializada.");
        out.writeObject(mensagem);

        Mensagem resposta = (Mensagem) in.readObject();
        System.out.println("Servidor respondeu: " + resposta.getTexto());

        socket.close();
    }
}
