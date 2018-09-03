import java.util.Scanner;
/**
 * returns true if input is grater than 6 else false.
 */
class InputValidator {
    /**.
     * { class variable }
     */
    private String input;
    /**.
     * @param      str   The string
     */
    public InputValidator(final String str) {
        this.input = str;
    }

    /**.
     * { checks length. }
     * @return     { boolean true or false }
     */
    boolean validateData() {
        int len = input.length();
        final int length = 6;
        if (len >= length) {
            return true;
        }
        return false;
    }

}
/**
 * Class for solution.
 */
public final class Solution {
    /**.
     * main class
     */
    private Solution() {
        //pass
    }
    /**.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
