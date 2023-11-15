package ex.lab06_3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PdfTextWriter implements TextWriter{
    @Override
    public void write(String filepath, String text) throws IOException {
        PrintWriter printWriter=new PrintWriter(new FileWriter(filepath));
        printWriter.println("printing in pdf format");
        printWriter.print(text);
        printWriter.close();
    }
}
