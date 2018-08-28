import java.util.Scanner;
/**
 * @author venkatesh
 */
public final class Solution {
    /**
     * @constructor
    */
    private Solution() {
        // cons
    }

    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * Mmain function
         */
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    @param      base      The base
    @param      exponent  The exponent
    @return     { description_of_the_return_value }
    */
    static long power(final int base, final int exponent) {
        /**
         * power function
         */
        if (exponent > 0) {
            return base * power(base, exponent - 1);
        }
        return 1;
    }
}
