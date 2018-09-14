import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){
        /**
         * { constructor }.
         */
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Shopingcart sc = new Shopingcart();
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        for (int i = 0; i <= lines; i++) {
            String[] line = s.nextLine().split(" ");
            if (line[0].equals("Item")) {
                String[] product = line[1].split(",");
                sc.addTocatalog(new Item(product[0], Integer.parseInt(product[1]),
                    Float.parseFloat(product[2])));
            }
            if (line[0].equals("catalog")) {
                sc.catalog();
            }
            if (line[0].equals("add")) {
                String[] shopping = line[1].split(",");
                sc.addToCart(new Item(shopping[0],
                    Integer.parseInt(shopping[1])));
            }
            if (line[0].equals("remove")) {
                String[] remove = line[1].split(",");
                sc.removeFromCart(new Item(remove[0],
                    Integer.parseInt(remove[1])));
            }
            if (line[0].equals("show")) {
                sc.show();
            }
            if (line[0].equals("totalAmount")) {
                System.out.println("totalAmount: " + sc.totalAmount());
            }
            if (line[0].equals("coupon")) {
                sc.applyCoupon(line[1]);
            }
            if (line[0].equals("payableAmount")) {
                System.out.println("Payable amount: " + sc.payableAmount());
            }
            if (line[0].equals("print")) {
                sc.print();
            }
        }
    }
}