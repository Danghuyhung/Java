package ex.lab06_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        TextEditor textEditor =(TextEditor) context.getBean("textEditor");
        textEditor.input("hello world....");
        textEditor.save("a.txt");
    }
}
