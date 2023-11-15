package ex.lab06_1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("appConfig.xml");
        Product p1=(Product) context.getBean("product1");
        Product p2=(Product) context.getBean("product2");
        Product p3=(Product) context.getBean("product3");

        System.out.println("Name bean 1:"+p1.getName());
        System.out.println("Name bean 2:"+p2.getName());
        System.out.println("Name bean 3:"+p3.getName());
    }
}
