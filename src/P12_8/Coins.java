package P12_8;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/7/13
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coins {
    //Coins stores a static representation of each coin (Penny, Nickel, Dime, Quarter) and the sum of the coins entered.
    //Also an int array of coins which will store the number of pennies, nickels, dimes and quarters and a double total
    //which will record the total amount of coins.
    public static double PENNY = .01;
    public static double NICKEL = .05;
    public static double DIME = .1;
    public static double QUARTER = .25;
    private int[] coins = new int[4];
    private double total = 0;

    public Coins(){

    }

    //A separate constructor so we can initialize the coin object in the vending machine with some money to start.
    public Coins(int penny, int nickel, int dime, int quarter) {
        coins[0] = penny;
        coins[1] = nickel;
        coins[2] = dime;
        coins[3] = quarter;
    }

    //Methods to add the different coin values to the array of count of each coin type.
    public void addPenny(){
        coins[0] += 1;
    }

    public void addNickel(){
        coins[1] += 1;
    }

    public void addDime(){
        coins[2] += 1;
    }

    public void addQuarter(){
        coins[3] += 1;
    }

    //Calculate the total value in the coin holder.
    public double getTotal(){
        total = coins[0]*.01 + coins[1]*.05 + coins[2]*.1 + coins[3]*.25;
        return total;
    }

    public int[] getCoins() {
        return coins;
    }

    //Zero out the array; this method is what happens when the money is collected out of the coin holder.
    public void resetCoins(){
        for (int i = 0; i < coins.length; i++) {
            coins[i] = 0;
        }
    }

    //This adds an entire coin array to the existing coin.
    public void addCoins(Coins coin){
        int[] coinArray = coin.getCoins();
        for (int i = 0; i <coinArray.length ; i++) {
            coins[i] += coinArray[i];
        }
    }

}
