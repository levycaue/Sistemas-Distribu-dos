package streams;

import java.io.InputStream;
import java.io.IOException;

public class MensagemInputStream extends InputStream {
    private InputStream origem;

    public MensagemInputStream(InputStream origem) {
        this.origem = origem;
    }

    @Override
    public int read() throws IOException {
        return origem.read();
    }
}
