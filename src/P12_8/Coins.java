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
    public static double PENNY = .01;
    public static double NICKEL = .05;
    public static double DIME = .1;
    public static double QUARTER = .25;
    private int[] coins;
    private double total = 0;

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

    public double getTotal(){
        total = coins[0]*.01 + coins[1]*.05 + coins[2]*.1 + coins[3]*.25;
        return total;
    }

    public int[] getCoins() {
        return coins;
    }

    public void resetCoins(){
        for (int i = 0; i < coins.length; i++) {
            coins[i] = 0;
        }
    }

    public void addCoins(Coins coin){
        int[] coinArray = coin.getCoins();
        for (int i = 0; i <coinArray.length ; i++) {
            coins[i] += coinArray[i];
        }
    }

}
