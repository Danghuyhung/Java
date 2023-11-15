package ex.lab06_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import ex.lab06_2.Product;
public class ApplicationConfiguration {
    @Bean
    @Scope("prototype")
    public Product Product1(){
        return new Product("1","iphone",1232.0,"like");
    }
    @Bean
    @Scope("prototype")
    public Product Product2() { return new Product(Product1()); }

    @Bean
    @Scope("singleton")
    public Product Product3(){
        return new Product("2","xsmax",1232.0,"like");
    }
}
