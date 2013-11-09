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

    public void addProduct(Product product){
        products.add(product);
    }

    public void addCoins(Coins c){
        coinCounter.addCoins(c);
    }

    public void checkMoney(){
        System.out.printf("There is %.2d in the machine.", coinCounter.getTotal());

    }

    public void printProductList(){
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getProductName() +  ", $" + products.get(i).getPrice());
        }
    }

    public void printProductInventory(){
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getProductName() +  ", " + products.get(i).getCount());
        }
    }

    public void collectMoney(){
        System.out.printf("Collecting money.  Withdrawing %.2d from the machine.", coinCounter.getTotal());
        coinCounter.resetCoins();
    }
}
