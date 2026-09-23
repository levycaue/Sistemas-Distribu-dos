package streams;

import java.io.OutputStream;
import java.io.IOException;
import pojo.Mensagem;

public class MensagemOutputStream extends OutputStream {
    private OutputStream destino;
    private Mensagem[] mensagens;
    private int quantidade;

    public MensagemOutputStream(OutputStream destino, Mensagem[] mensagens, int quantidade) {
        this.destino = destino;
        this.mensagens = mensagens;
        this.quantidade = quantidade;
    }

    @Override
    public void write(int b) throws IOException {
        destino.write(b);
    }

    public void enviarMensagens() throws IOException {
        for (int i = 0; i < quantidade; i++) {
            String dados = mensagens[i].toString() + "\n";
            destino.write(dados.getBytes());
        }
    }
}
