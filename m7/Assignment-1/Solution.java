import java.util.Scanner;
/**
 * . returns true if input is grater than 6 else false.
 */
class InputValidator {
    String input;
    public InputValidator(final String str) {
        this.input = str;
    }
    public boolean validateData() {
        int len = input.length();
        final int length = 6;
        if (len >= length) {
            return true;
        } else {
            return false;
        }
    }

}
/**
 * . Class for solution.
 */
public class Solution {
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
