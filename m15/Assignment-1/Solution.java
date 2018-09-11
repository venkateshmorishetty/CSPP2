import java.util.Scanner;
/**
 * Exception for signaling invalid position errors.
 */
class InvalidPositionException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidPositionException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling invalid position errors.
 */
class IndexOutofBoundsException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    IndexOutofBoundsException(final String s) {
        super(s);
    }
}
/**
 * List of .
 */
class List {
    /**
     * { var_description }.
     */
    private int[] list;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    List() {
        final int s = 20;
        list = new int[s];
        size = 0;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        list[size++] = item;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * { function_description }.
     * @param      index      The index
     *
     * @throws     Exception  { exception_description }
     */
    public void remove(final int index) throws InvalidPositionException {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            } list[size - 1] = 0;
        } else {
            throw new InvalidPositionException("Invalid Position Exception");
        }
        size--;
    }
    /**
     * { function_description }.
     * @param      index  The index
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        if (index >= 0 && index < size) {
            return list[index];
        }
        return -1;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String s = "[";
            for (int i = 0; i < size - 1; i++) {
                s += list[i] + ",";
            } s += list[size - 1] + "]";
            return s;
        }
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        boolean check = contains(item);
        if (check) {
            for (int i = 0; i < size; i++) {
                if (item == list[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     * @param      item   The item
     */
    public void add(final int index, final int item) {
        if (index >= 0 && index < size) {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            } list[index] = item;
            size++;
        }
    }
    /**
     * Adds all.
     *
     * @param      items  The items
     */
    public void addAll(final int[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int count(final int item) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                count++;
            }
        }
        return count;
    }
    /**
     * Removes all.
     *
     * @param      items      The items
     *
     * @throws     Exception  { exception_description }
     */
    public void removeAll(final int[] items) throws Exception {
        boolean check;
        for (int i : items) {
            check = contains(i);
            while (check) {
                remove(indexOf(i));
                check = contains(i);
            }
        }
    }
    /**
     * { function_description }.
     *
     * @param      start      The start
     * @param      end        The end
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    public List subList(final int start, final int end) throws IndexOutofBoundsException {
        if (end > size || end < 0 || start < 0 || start == end) {
            throw new IndexOutofBoundsException("Index Out of Bounds Exception");
        } else {
            List l1 = new List();
            for (int i = start; i < end; i++) {
                l1.add(list[i]);
            }
            return l1;
        }
    }
    /**
     * { function_description }.
     *
     * @param      l     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean equals(final List l) {
        return toString().equals(l.toString());
    }
    /**
     * { function_description }.
     */
    public void clear() {
        size = 0;
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
        //pass
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        List l = new List();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "add":
                try {
                l.add(Integer.parseInt(tokens[1]));
                } catch (Exception e) {
                    String[] val = tokens[1].split(",");
                    l.add(Integer.parseInt(val[0]), Integer.parseInt(val[1]));
                }
                break;
                case "size":
                System.out.println(l.size());
                break;
                case "remove":
                try {
                    l.remove(Integer.parseInt(tokens[1]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(l.toString());
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
                case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "addAll":
                String[] ele = tokens[1].split(",");
                int[] ele1 = new int[ele.length];
                for (int i = 0; i < ele.length; i++) {
                ele1[i] = Integer.parseInt(ele[i]);
                }
                l.addAll(ele1);
                break;
                case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;
                case "removeAll":
                if (tokens.length == 2) {
                    String[] arr = tokens[1].split(",");
                    int[] arr1 = new int[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        arr1[i] = Integer.parseInt(arr[i]);
                    }
                    try {
                        l.removeAll(arr1);
                    } catch (Exception e) { }
                }
                break;
                case "subList":
                String[] index = tokens[1].split(",");
                try {
                    System.out.println(l.subList(Integer.parseInt(index[0]),
                        Integer.parseInt(index[1])));
                } catch (Exception e) {
                System.out.println(e.getMessage());
                }
                break;
                case "equals":
                if (tokens.length == 2) {
                    List equal = new List();
                    String[] arr2 = tokens[1].split(",");
                    for (int i = 0; i < arr2.length; i++) {
                        equal.add(Integer.parseInt(arr2[i]));
                    } System.out.println(l.equals(equal));
                }
                break;
                case "clear":
                l.clear();
                break;
                default:
            }
        }
    }
}
