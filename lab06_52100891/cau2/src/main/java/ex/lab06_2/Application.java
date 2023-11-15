package ex.lab06_2;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=  new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Product p1=(Product) context.getBean("Product1");
        Product p2=(Product) context.getBean("Product2");
        Product p3=(Product) context.getBean("Product3");

        System.out.println("Name bean 1:"+p1.getName());
        System.out.println("Name bean 2:"+p2.getName());
        System.out.println("Name bean 3:"+p3.getName());
    }
}
