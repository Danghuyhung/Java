package com.example.cau4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // read spring java configuration class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TextEditor textEditor = context.getBean("textEditor", TextEditor.class);
        textEditor.input("Hello world..");
        textEditor.save();
    }
}
