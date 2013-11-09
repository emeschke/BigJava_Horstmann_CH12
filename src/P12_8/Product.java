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

    //Initialize the product with a name, inventory count and price.
    public Product(String name, int count, double price){
        this.productName = name;
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    //Add inventory to the product.  It is possible to take out inventory (a negative number) but method checks to
    //make sure it won't go below 0.
    public void addCount(int count) {
        this.count += count;
        this.count = Math.max(0, this.count);
    }

    //Decrement the inventory count by 1 to represent a purchase.
    public void buyItem(){
        this.count -= 1;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }
}
