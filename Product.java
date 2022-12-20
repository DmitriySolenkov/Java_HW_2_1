import java.lang.reflect.Constructor;

public class Product {

    private int id;
    private String name;
    private int price;
    

    public Product(int id, String name, int price) {
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public String toString() {
        return String.format(" Код: %d| Название: %s| Цена: %d", id, name, price);
    }
    
}