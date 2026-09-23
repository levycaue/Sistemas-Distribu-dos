package service;

import java.io.*;
import java.net.*;

public class VotingClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 12345);

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        out.writeObject(2);

        String resposta = (String) in.readObject();
        System.out.println("Servidor respondeu: " + resposta);

        socket.close();
    }
}
