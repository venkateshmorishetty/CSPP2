import java.util.Scanner;
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    String input;
    public InputValidator(String str) {
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
public class Solution {
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());

    }

}
