package ex.lab06_3;

import java.io.IOException;

public interface TextWriter {
    public void write(String filepath, String text) throws IOException;
}
