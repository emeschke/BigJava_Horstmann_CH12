package P12_8;

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
    private Scanner in = new Scanner(System.in);
    VendingMachine vendingMachine;

    public VendingMachineInterface(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public boolean bigMenu(){
        String user = chooseUser();
        if (user.equals("A")){
            buyMenu();
            return true;
        }
        else if(user.equals("B")){
            ownerMenu();
            return true;
        }
        else return false;
    }
    public String chooseUser(){
        System.out.printf("Please choose your status. \nA. Buyer. \nB. Owner.\nAny other key to exit: ");
        return in.nextLine();
    }

    public void buyMenu(){
        String buyChoice;
        vendingMachine.printProductList();
        do{
        System.out.printf("What would you like to do? \nA. Enter coins. \nB. Buy something.\nAny other key to exit.");
        buyChoice = in.nextLine();

            if (buyChoice.equals("A")){
                System.out.println("Enter a coin value to add ($.01, $.05, $.1, $.25): ");
                try{
                    //Need to add coin.
                    in.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("Not a valid coin.");
                }
            }

            else if (buyChoice.equals("B")){
                vendingMachine.printProductList();
                //Try to buy something
            }
        }
        while(buyChoice.equals("A") || buyChoice.equals("B"));
    }

    public void ownerMenu(){
        String ownerChoice;
        do{
            System.out.println("What would you like to do? \n A. Check money. \nB. Collect money. \n" +
                               "C. Check inventory.\n D. Add inventory.");
            System.out.printf("What is your choice: ");
            ownerChoice = in.nextLine();
            if (ownerChoice.equals("A")){
                vendingMachine.checkMoney();
            }
            else if (ownerChoice.equals("B")){
                vendingMachine.collectMoney();
            }
            else if (ownerChoice.equals("C")){
                vendingMachine.printProductList();
            }
            else if (ownerChoice.equals("D")){
                //Add products
            }
        }
        while(ownerChoice.equals("A") || ownerChoice.equals("B") || ownerChoice.equals("C") || ownerChoice.equals("D"));
    }

}

