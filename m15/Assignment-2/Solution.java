import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
/**
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidSubsetSelectionException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    SetEmptyException(final String s) {
        super(s);
    }
}
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
    public int last() throws SetEmptyException{
        if (size == 0) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
            return set[size - 1];
        }
    }

    /**
     * { function_description }.
     *
     * @param      fromele  The fromele
     * @param      toele    The toele
     *
     * @return     { description_of_the_return_value }
     */
    public int[] subSet(final int fromele, final int toele) throws InvalidSubsetSelectionException {
        if(fromele > toele) {
            throw new InvalidSubsetSelectionException("Invalid Arguments to Subset Exception");
        } else {
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
    }

    /**
     * { function_description }.
     *
     * @param      ele   The ele
     *
     * @return     { description_of_the_return_value }
     */
    public int[] headSet(final int ele) throws SetEmptyException {
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
        if (arr.length == 0) {
            throw new SetEmptyException("Set Empty Exception");
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
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // code to read the test cases input file
        Sortedset s = new Sortedset();
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
                try {
                System.out.println(s.last());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "subSet":
                try {
                String[] token = tokens[1].split(",");
                int[] res = s.subSet(Integer.parseInt(token[0]),
                    Integer.parseInt(token[1]));
                if (res.length == 0) {
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
                    System.out.println(e.getMessage());
                }
                break;
                case "headSet":
                try {
                int[] res1 = s.headSet(Integer.parseInt(tokens[1]));
                String s1 = "{";
                for (int i = 0; i < res1.length - 1; i++) {
                    s1 += res1[i] + ", ";
                }
                s1 += res1[res1.length - 1] + "}";
                System.out.println(s1);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "intersection":
                // int[] intArray = intArray(tokens[1]);
                s = new Sortedset();
                Sortedset t = new Sortedset();
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Sortedset();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                default:
            }
        }
    }
}
