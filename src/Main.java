import pojo.Mensagem;
import streams.MensagemOutputStream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Mensagem[] mensagens = {
            new Mensagem("Olá, Cleicinara!"),
            new Mensagem("Testando o stream personalizado."),
            new Mensagem("Tudo funcionando direitinho!")
        };

        MensagemOutputStream mos = new MensagemOutputStream(System.out, mensagens, mensagens.length);
        mos.enviarMensagens();
    }
}
