
import java.util.Scanner;
/**.
 * { maximu in a given array }
 */
final class Solution {
/**.
	Fill this main function to print maximum of given array
	*/
	private Solution() {
		//constructor
	}
	/**.
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		int max;
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int[] a;
		a=new int[n];
		for(int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		max = a[0];
		for(int i = 1; i < n; i++) {
			if(max < a[i]) {
				max = a[i];
			}
		}
		System.out.println(max);
	}
}
