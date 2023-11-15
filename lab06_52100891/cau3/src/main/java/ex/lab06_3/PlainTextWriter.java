package ex.lab06_3;
import java.io.FileWriter;
import java.io.IOException;
public class PlainTextWriter implements TextWriter{
    @Override
    public void write(String filepath, String text) {
        try {
            FileWriter myWriter = new FileWriter(filepath);
            myWriter.write(text);
            System.out.println("Text saved to file: " + filepath);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}
