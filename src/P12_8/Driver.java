package P12_8;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/8/13
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
General setup--There are a couple of classes.  A product class which holds a product name, cost and inventory.  A coin
 class, which holds an array of coins (penny, nickel, dime, quarter.)  This is not a single coin, but a holder of coins.
 It is aware of how many of each there are and also their values.  The vending machine class has an array of products
 (its inventory) and a Coins object which holds the coins that have been collected as a result of purchases.

 The VendingMachineInterface class is the set of menus with which the user interacts.  It sets on top of a Vending
 Machine in order to interact with it.  It also has a coin object to hold the balance of a user transaction before
 it has been processed and the money collected or refunded.

 The driver creates a Vending Machine with 5 products and some money initially to make testing easier.  All the methods
 in the menus work.  The only bug is that both of the secondary sub-menus have a bug where they print the menu twice in
 some cases.  Is that a problem with the do-while formulation of the loop?





 */
public class Driver {

    public static void main(String[] args) {
        //Create Vending Machine and VendingMachineInterface that attaches to the vending machine.
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineInterface vmi = new VendingMachineInterface(vendingMachine);

        //Start the vending machine with products and some money initially.
        vendingMachine.addProduct(new Product("Coke", 12,.25));
        vendingMachine.addProduct(new Product("Sprite", 10,.35));
        vendingMachine.addProduct(new Product("Coke", 8,.50));
        vendingMachine.addProduct(new Product("Rootbeer", 14,.3));
        vendingMachine.addProduct(new Product("Slice", 0,.45));
        Coins startMoney = new Coins(3,5,4,10);
        vendingMachine.addCoins(startMoney);

        //Run the VendingMachineInterface.
        while (vmi.bigMenu()){}
    }
}

