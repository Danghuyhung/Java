package ex.lab06_2;

public class Product {
    private String id;
    private String name;
    private Double price;
    private String description;

    public Product(String id, String name, double price, String description) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.description=description;
    }

    public Product(Product product) {
        this.id=product.id;
        this.name=product.name;
        this.price=product.price;
        this.description=product.description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product() {
        this.id = null;
        this.name = null;
        this.price = null;
        this.description = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
