import java.util.Scanner;
import java.io.BufferedInputStream;
/**
 * Class for sortedset.
 */
class Sortedset extends Set {
    /**
     * holds the elemtns in this Set array.
     */
    Sortedset() {
    }
    /**
     * add all elements of the array to this Set.
     * @param arr as an arr to be added in this set,
     *            if the element is not present in this set.
     */
    public void addAll(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int last() {
        if (size == 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
        return set[size - 1];
    }

    /**
     * { function_description }.
     *
     * @param      fromele  The fromele
     * @param      toele    The toele
     *
     * @return     { description_of_the_return_value }
     */
    public int[] subSet(final int fromele, final int toele) {
        int count = 0, temp = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] >= fromele && set[i] < toele) {
                count++;
            }

        }
        int[] arr = new int[count];
        for (int j = 0; j < size; j++) {
            if (set[j] >= fromele && set[j] < toele) {
                arr[temp] = set[j];
                temp++;
            }
        }
        return arr;
    }

    /**
     * { function_description }.
     *
     * @param      ele   The ele
     *
     * @return     { description_of_the_return_value }
     */
    public int[] headSet(final int ele) {
        int count = 0, temp = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] < ele) {
                count++;
            }
        }
        int[] arr = new int[count];
        for (int i = 0; i < size; i++) {
            if (set[i] < ele) {
                arr[temp] = set[i];
                temp++;
            }
        }
        return arr;
    }

}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * { item_description }.
         */

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        Sortedset s = new Sortedset();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                s.add(Integer.parseInt(tokens[1]));
                break;
                case "print":
                System.out.println(s.toString());
                break;
                case "addAll":
                String[] arr = tokens[1].split(",");
                int[] arr1 = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    arr1[i] = Integer.parseInt(arr[i]);
                }
                s.addAll(arr1);
                break;
                case "last":
                System.out.println(s.last());
                break;
                case "subSet":
                try {
                String[] token = tokens[1].split(",");
                int[] res = s.subSet(Integer.parseInt(token[0]),
                    Integer.parseInt(token[1]));
                if (Integer.parseInt(token[0]) > Integer.parseInt(token[1])) {
                    System.out.println("Invalid Arguments to Subset Exception");
                    break;
                } else if (res.length == 0) {
                    System.out.println("{}");
                    break;
                } else {
                String s1 = "{";
                for (int i = 0; i < res.length - 1; i++) {
                    s1 += res[i] + ", ";
                }
                s1 += res[res.length - 1] + "}";
                System.out.println(s1);
                }
                } catch (Exception e) {
                    System.out.println("Invalid Arguments to Subset Exception");
                }
                break;
                case "headSet":
                int[] res1 = s.headSet(Integer.parseInt(tokens[1]));
                if (res1.length == 0) {
                    System.out.println("{}");
                } else {
                String s1 = "{";
                for (int i = 0; i < res1.length - 1; i++) {
                    s1 += res1[i] + ", ";
                }
                s1 += res1[res1.length - 1] + "}";
                System.out.println(s1);
                }
                break;
                default:
            }
        }
    }
}
