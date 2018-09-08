import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class Set {
    //your code goes here...
    //Good luck :-)
    int[] set;
    int size;
    public Set(){
        set = new int[20];
        size = 0; 
    }

    public int size() {
        return size;
    }
    public void add(int item) {
        boolean check;
        check = contains(item);
        if(!check){
            set[size] = item;
            size++;
        }
    }
    public void add(int[] items){
        for(int i:items){
            add(i);
        }
    }

    public boolean contains(int item){
        for(int i = 0;i<size;i++){
            if(item == set[i]){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        if(size == 0){
            return "{}";
        }
        String s;
        s = "{";
        for(int i = 0;i<size-1;i++){
            s += set[i]+", ";
        }s += set[size-1]+"}";
        return s;
    }
    public int get(int index){
        if(index>=0 && index<size){
            return set[index];
        }
        return -1;
    }
    public Set intersection(Set items){
        if(size == 0 && items.size==0){
            return null;
        }
        Set s1 = new Set();
        boolean check;
        int limit = items.size();
        for(int i=0;i<size;i++){
            for(int j=0;j<limit;j++){
                if(set[i] == items.get(j)){
                    s1.add(set[i]);  
                }
            }
        }
    return s1; 

    }
    public Set retainAll(int[] items){
        
        Set s1 = new Set();
        boolean check;
        for(int i=0;i<size;i++){
            for(int j=0;j<items.length;j++){
                if(set[i] == items[j]){
                    s1.add(set[i]);  
                }
            }
        }
    return s1; 
    }
    public String[][] cartesianProduct(Set set1){
        String str="",str2="";
        int limit1 = set1.size();

        if(set1.size() == 0 && size == 0){
            return null;
        } else {
            String[][] s = new String[size][limit1];
            for(int i =0;i<size;i++){
                str += "["+set[i]+",";
                for(int j = 0;j<limit1;j++){
                    str2 += str + set1.get(j)+"]";
                    s[i][j] = str2;
                    str2 = "";
                }
                str = "";
            }
            return s;
        }
        
    }
}

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    public  Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
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
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
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
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                case "get":
                System.out.println(s.get(Integer.parseInt(tokens[1])));
                break;
                default:
                break;
            }
        }
    }
}
