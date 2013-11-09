package P12_8;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Product {
    private String productName;
    private int count;
    private double price;

    public Product(String name, int count, double price){
        this.productName = name;
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }
}
