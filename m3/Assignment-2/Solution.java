import java.util.Scanner;
/**.
 @author = 'venkatesh'
*/
final class Solution {
/**.
 * Fill the main function to print the number of 7's between 1 to n
 */
    private Solution() {
        //construcor
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        final int div = 10;
        final int res = 7;
        final int dec = 10;
        for (int i = 0; i <= n; i++) {
            int temp1 = i;
            while (temp1 > 0) {
                if (temp1 % div == res) {
                count += 1;
                }
            temp1 = Math.round(temp1 / dec);
            }
        }
        System.out.println(count);
    }
}

