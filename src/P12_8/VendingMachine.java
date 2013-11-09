package P12_8;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendingMachine {
    private ArrayList<Product> products = new ArrayList<Product>();
    private Coins coinCounter = new Coins();

    //Add a product to the machine.  Only used in initializing the vending machine.
    public void addProduct(Product product){
        products.add(product);
    }

    //Add coins to the machine.  Also only used at initialization.
    public void addCoins(Coins c){
        coinCounter.addCoins(c);
    }

    //Check how much money is in the machine.
    public double checkMoney(){
        return coinCounter.getTotal();
    }

    //Return the array of products.  Is this good form, passing an array of the products like this?
    public ArrayList<Product> getProducts(){
        return products;
    }

    //Get the inventory of a particular item.
    public int getProductInventory(int i){
        return products.get(i).getCount();
    }

    //Reset the coin counter to zero because the coins have been collected or deposited.
    public void collectMoney(){
        coinCounter.resetCoins();
    }

    //Add a specified amount of inventory to the product inventory in the vending machine.
    public void addInventory(int choice, int addNumber){
        products.get(choice).addCount(addNumber);
    }

    //Return the price of an item from the product list.
    public double getCost(int item){
        return products.get(item).getPrice();
    }

    //Get the name of a product
    public String getName(int item){
        return products.get(item).getProductName();
    }

    //Buy an item from the product list.
    public void buyItem(int item){
        products.get(item).buyItem();
    }

}
