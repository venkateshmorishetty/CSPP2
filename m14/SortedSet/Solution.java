import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
class Set {

    /**
     * This constant is used to create an array
     * with the initial capacity.
     */
    public static final int TEN = 10;

    /**
     * holds the elemtns in this Set array.
     */
    private int[] set;

    /**
     * indicates the number of elememnts of this set.
     */
    private int size;

    /**
     * Default constructor to create an array with the szie 10.
     */
    public Set() {
        set = new int[TEN];
        size = 0;
    }

    /**
     * add the item to this set at the last.
     * If the set is full, resize the set to double
     * the size of the current set.
     * @param item to be inserted at the last.
     */
    public int max(){
        int max = 0;
        for(int i = 0; i < size; i++) {
            if (set[i] > max) {
                max = set[i];
            }
        }
        return max;
    }
    public void add(int item) {
        int max;
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            max = max();
            if(size == 0 || item > max){
                set[size++] = item;
            }
            else{
            for(int i = 0; i < size; i++){
                    if(set[i]>item){
                        for(int j = size;j>i;j--){
                            set[j] = set[j-1];
                        }
                        set[i] = item; 
                        break;   
                    }
                }
                size++;
            }       
        }
    }

    /**
     * resize the set by double, when it is full.
     */
    private void resize() {
        set = java.util.Arrays.copyOf(set, size * 2);
    }

    /**
     * add all elements of the array to this Set.
     * @param arr as an arr to be added in this set,
     *            if the element is not present in this set.
     */
    public void addAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    /**
     * Finds the intersection of the two sets.
     * @param  other as set 2.
     * @return the result that contains the common
     * elements of the two sets.
     */
    public Set intersection(Set other) {
        Set result = new Set();
        for (int i = 0; i < this.size; i++) {
            if (other.contains(this.get(i))) {
                result.add(this.get(i));
            }
        }
        return result;
    }

    /**
     * retains all the elements from the set.
     * @param  arr is a form of set2.
     * @return the set that contains all the elements
     * of this set.
     */
    public Set retainAll(final int[] arr) {
        Set other = new Set();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }

    /**
     * This finds out the cartesian product of two sets.
     * @param  other as a Set 2.
     * @return the cartesian product in the form of 2D array.
     */
    public int[][] cartesianProduct(final Set other) {
        int [][] result = new int[this.size() * other.size()][2];
        int k = -1;
        if (this.size() == 0 || other.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < other.size(); j++) {
                result[++k][0] = this.get(i);
                result[k][1] = other.get(j);
            }
        }
        return result;
    }

    /**
     * This methods finds out the number of elements in the set.
     * @return the integer value indicates the number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * This method finds out the elements
     * at a particular index.
     * @param  index to return the element at this index.
     * @return the element at this index, otherwise return -1.
     */
    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            return -1;
        } else {
            return set[index];
        }
    }

    /**
     * String version of the object.
     * @return string.
     */
    public String toString() {
        if (this.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(set[i] + ", ");
        }
        sb.append(set[size - 1] + "}");
        return sb.toString();
    }

    /**
     * returns true if this set contains the item.
     * @param  item as a parameter to be checked in the set.
     * @return      true if the item present in the set,
     *                   otherwise false.
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Finds the index of the item in this set.
     * @param  item to be find in this set.
     * @return the index if the item is found in this set,
     * otherwise false.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
    public String last(){
        if(size == 0){
            return "Set Empty Exception";
        }
        return set[size-1]+"";
    }
    public int[] subSet(int fromele, int toele) throws Exception{
        // System.out.println("im in");
        int count = 0, temp = 0;
        for(int i = 0; i < size; i++) {
            if(set[i]>=fromele && set[i] < toele){
                count++;
            }

        }
        int[] arr = new int[count];
        for(int j = 0; j < size; j++) {
            if(set[j]>=fromele && set[j] < toele){
                arr[temp] = set[j];
                temp++;
            }
        }
        return arr;
    }
    public int[] headSet(int ele){
        int to = indexOf(ele);
        if(ele > max()){
            return set;
        }
        int[] arr = new int[to];
        for(int i = 0; i < to; i++) {
            arr[i] = set[i];
        }
        return arr;
    }
}
// class sortedSet extends Set{
//     public 
// }
class Solution{
     public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
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
                case "add":
                s.add(Integer.parseInt(tokens[1]));
                break;
                case "print":
                System.out.println(s.toString());
                break;
                case "addAll":
                String[] arr = tokens[1].split(",");
                int[] arr1 = new int[arr.length];
                for(int i = 0; i < arr.length; i++) {
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
                int[] res = s.subSet(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
                if(res.length == 0){
                    System.out.println("Invalid Arguments to Subset Exception");
                }
                else{
                String s1 = "{";
                for (int i = 0; i < res.length - 1; i++) {
                    s1 += res[i] + ", ";
                }
                s1 += res[res.length - 1] + "}";
                System.out.println(s1);
                }
                } catch(Exception e) {
                    System.out.println("Invalid Arguments to Subset Exception");
                }
                break;
                case "headSet":
                int[] res1 = s.headSet(Integer.parseInt(tokens[1]));
                
                if(res1.length == 0){
                    System.out.println("{}");
                }
                else{
                String s1 = "{";
                for (int i = 0; i < res1.length - 1; i++) {
                    s1 += res1[i] + ", ";
                }
                s1 += res1[res1.length - 1] + "}";
                System.out.println(s1);
                }
                break;
            }
        }
    }
}
