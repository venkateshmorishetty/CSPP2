/**.
 *binary to decimal conversion.
*/
import java.util.Scanner;
public final class Solution {/**.
	Do not modify this main function.
	*/
	private Solution() {
		//constructor.
	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= n; i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	/**
	 * { function_description }
	 *
	 * @param      str     { binary value in str format }
	 *
	 * @return   res  { returns decimal value of binary. }
	 */
	public static String binaryToDecimal(final String str) {
		Long number = Long.parseLong(str);
		int res = 0;
		int power = 0;
		int div = 5*2;
		while(number != 0) {
			Long rem = number % div;
			res += rem * Math.pow(2, power);
			number = number / 10;
			power += 1;
		}
		return res + "";
	}
}	