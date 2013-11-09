package P12_8;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 11/8/13
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {

    public static void main(String[] args) {
        VendingMachine vi = new VendingMachine();
        VendingMachineInterface vmi = new VendingMachineInterface(vi);
        vi.addProduct(new Product("Coke", 12,2.25));
        vi.addProduct(new Product("Sprite", 10,1.25));
        vi.addProduct(new Product("Coke", 8,1.50));
        vi.addProduct(new Product("Rootbeer", 14,1.75));
        vi.addProduct(new Product("Slice", 11,2.00));
        while (vmi.bigMenu()){}
    }
}

