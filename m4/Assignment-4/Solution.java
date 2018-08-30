import java.util.Scanner;
/**.
 * revrse of given string
 */
public final class Solution {
/**.
 * Do not modify the main function
 */
    private Solution() {
        /**.
        constructor
        */
    }
    private static String reverse = "";
    /**.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**.
     * @param      string  user input
     * @return     { revrse of given string }
     */
    public static String reverseString(final String string) {
        char[] arr = string.toCharArray();
        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            reverse += arr[i];
        }
        return reverse;
    }

}
