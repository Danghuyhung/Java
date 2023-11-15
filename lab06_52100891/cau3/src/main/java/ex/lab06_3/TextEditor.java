package ex.lab06_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;

public class TextEditor {
    private String text;
    @Autowired
    @Qualifier("PdfTextWriter")
    private TextWriter writer;

    public void save(String filePath) throws IOException {
        writer.write(filePath,this.text);
    }
    public void input(String text){
        this.text=text;
    }
}
