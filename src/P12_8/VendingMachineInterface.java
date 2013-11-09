package P12_8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/8/13
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class VendingMachineInterface {
    //Create a scanner class and the vending machine object which this interface will reference.
    private Scanner in = new Scanner(System.in);
    VendingMachine vendingMachine;
    //This coins object holds the coins inserted in anticipation of the present transaction but not yet exchanged
    //for a product.
    Coins transactionCoin = new Coins();

    //Constructor of a vending machine interface that is passed a vending machine.
    public VendingMachineInterface(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    //Big Menu is the first menu that allows the user to designate as the owner (with owner privileges or a
    //user, with buying privileges.  If neither is entered the machine continues to run until the "X" is pressed
    //to turn it off.  Not sure how to simulate a machine that is always on in a program that should exit.
    public boolean bigMenu(){
        //Call chooseUser, which prints a menu and takes an input.  Branch to the appropriate statement.
        String user = chooseUser();
        if (user.equals("A")){
            buyMenu();
            return true;
        }
        else if(user.equals("B")){
            ownerMenu();
            return true;
        }
        else if(user.equals("X")){
            return false;
        }
        else{
            return true;
        }
    }


    public String chooseUser(){
        System.out.printf("\nPlease choose your status. \nA. Buyer. \nB. Owner.\nX. to exit: ");
        return in.nextLine();
    }

    //buyMenu is where the user is directed if he chooses that he is a customer.
    public void buyMenu(){
        String buyChoice;
        int counter = 0;
        //Print the product and prompt the user to make a choice about what they want to do.  Get the input.
        printProductList(vendingMachine.getProducts());
        do{
            System.out.printf("\nWhat would you like to do? \nA. Enter coins. \nB. Buy something.\nX. Back to first menu.");
            //counter +=1;
            //System.out.println("Count: " + counter);
            buyChoice = in.next();
            //If statement that branches according to the user choice.
            if (buyChoice.equals("A")){
                //Try catch that adds a coin to the user as long as the coin entered is a double value and
                //the coin value corresponds to a real coin.  The finally statement prints the users balance.
                System.out.println("Enter a coin value to add ($.01, $.05, $.1, $.25): ");
                try{
                    double inputCoin= in.nextDouble();
                    if (inputCoin == .01){
                        transactionCoin.addPenny();
                    }
                    else if (inputCoin == .05){
                        transactionCoin.addNickel();
                    }
                    else if (inputCoin == .1){
                        transactionCoin.addDime();
                    }
                    else if (inputCoin == .25){
                        transactionCoin.addQuarter();
                    }
                    else{
                        System.out.println("Not a valid coin.");
                    }

                }catch(InputMismatchException e){
                    System.out.println("Not a valid coin.");

                }finally {
                    System.out.printf("Balance for this purchase is $%.2f.\n", transactionCoin.getTotal());
                }
            }

            else if (buyChoice.equals("B")){
                //The user chooses to buy something.  Print the list, get the user's choice to buy.  Check whether
                //the user balance is enough to purchase the item and there is at least one in inventory.
                //If it is possible for the user to buy the product, then the product count is decremented and the
                //user balance is transferred over to the coin array within the vending machine.  If there is not a
                //enough money in the user balance, the user money is refunded.  If there is not enough inventory,
                //the money is refunded.  If the user input is not valid, the user is told.  This menu is reset
                //while the user chooses to add money or buy things.
                int product;
                printProductList(vendingMachine.getProducts());
                System.out.printf("Balance for this purchase is $%.2f.\n", transactionCoin.getTotal());
                try{
                    System.out.println("Choose the number of a product to buy: ");
                    product = in.nextInt();
                    if (vendingMachine.getCost(product) <= transactionCoin.getTotal() &&
                        vendingMachine.getProductInventory(product) > 0){
                        System.out.println("Buying " + vendingMachine.getName(product));
                        vendingMachine.buyItem(product);
                        vendingMachine.addCoins(transactionCoin);
                        transactionCoin.resetCoins();
                    }
                    else if (vendingMachine.getCost(product) > transactionCoin.getTotal()){
                        System.out.println("Not enough money--refunding coins.");
                        transactionCoin.resetCoins();
                    }
                    else if (vendingMachine.getProductInventory(product) <= 0){
                        System.out.println("Sold out.  Sorry!  Refunding coins.");
                        transactionCoin.resetCoins();
                    }
                }catch(InputMismatchException|ArrayIndexOutOfBoundsException e){
                    System.out.println("Not a valid choice.  Please try again.");
                }
            }
        }
        while(!buyChoice.equals("X"));
    }

    //Owner menu is for the owner of the machine, he can view money/inventory; remove money or add/remove inventory.
    public void ownerMenu(){
        String ownerChoice;
        //Menu with the above choices, takes an input.
        do{
            System.out.println("\nWhat would you like to do? \nA. Check money. \nB. Collect money. \n" +
                               "C. Check inventory.\nD. Add inventory.\nX. to exit.");
            System.out.printf("What is your choice: ");
            ownerChoice = in.nextLine();
            if (ownerChoice.equals("A")){
            //Print the amount of money in the vending machine.
                System.out.printf("There is $%.2f in the machine.\n", vendingMachine.checkMoney());
            }
            else if (ownerChoice.equals("B")){
            //Collect the money.  Owner withdraws money and vending machine balance is back to zero.
                System.out.printf("Collecting money.  Withdrawing $%.2f from the machine.", vendingMachine.checkMoney());
                vendingMachine.collectMoney();
            }
            else if (ownerChoice.equals("C")){
            //Print the inventory count.
                printProductInventory(vendingMachine.getProducts());
            }
            else if (ownerChoice.equals("D")){
            //Add/remove inventory.  Because of the specs of methods in other classes, there can never be negative
            //inventory.
                int productAdd;
                int amtToAdd;
                printProductInventory(vendingMachine.getProducts());
                try{
                    System.out.println("Choose a product brand to add: ");
                    productAdd = in.nextInt();
                    System.out.println("How many are added: ");
                    amtToAdd = in.nextInt();
                    vendingMachine.addInventory(productAdd, amtToAdd);
                }catch(InputMismatchException|ArrayIndexOutOfBoundsException e){
                    System.out.println("Not a valid choice.");
                }
            }
        }
        while(!ownerChoice.equals("X"));
    }

    public void printProductInventory(ArrayList<Product> products){
        //Print the product inventory from array passed from Vending machine.
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + ". "+products.get(i).getProductName() +  ", " + products.get(i).getCount());

        }
    }

    public void printProductList(ArrayList<Product> products){
        //Print a list of products and cost of each.
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + ". "+products.get(i).getProductName() +  ", $" + products.get(i).getPrice());

        }
    }
}

