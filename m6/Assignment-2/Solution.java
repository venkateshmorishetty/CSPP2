import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : 
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] round(final int[][] a, final int rows, final int columns) {
    final int size = 11;
    final int multiple = 100;
    final int mid = 50;
	int[] multiples = new int[size];
    for (int i = 0; i < size; i++) {
        multiples[i] = i * multiple;
    }
    int temp = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            for (int k = 0; k < multiples.length; k++) {
                temp = Math.round(a[i][j] - multiples[k]);
                if (temp < mid) {
                    a[i][j] = multiples[k];
                    break;
                }
                else if (temp == mid) {
                    a[i][j] = multiples[k + 1];
                    break;
                }
            }
        }

    }
	return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = round(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
