import java.util.Scanner;
/**.
 *binary to decimal conversion.
*/
public final class Solution {
/**.
    Do not modify this main function.
    */
    private Solution() {
        //constructor.
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**.
     * { function_description }
     *
     * @param      str     { binary value in str format }
     *
     * @return   res  { returns decimal value of binary. }
     */
    public static String binaryToDecimal(final String str) {
        Long number = Long.parseLong(str);
        int res = 0;
        int power = 0;
        final int div = 10;
        while (number != 0) {
            Long rem = number % div;
            res += rem * Math.pow(2, power);
            number = number / div;
            power += 1;
        }
        return res + "";
    }
}
