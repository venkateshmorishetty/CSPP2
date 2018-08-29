import java.util.Scanner;
/**.
 Do not modify this main function.
*/
final class Solution {
/**.
 * gcd of two numbers.
 */
    private Solution(){
        //pass
    }
    public static void main(final String[] args) {
        Scanner s=new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1,n2);
    }
    /**.
    Need to write the gcd function and print the output.
    @param      a     {first value }
    @param      b     {second value}
    */
    public static void gcd(int a, int b) {
        int gcd = 1;
        if(b < a){
            int temp1 = a;
            a = b;
            b = temp1;
        }
        for(int i = 1; i <= b; i++) {
            if(b % i == 0 && a % i == 0) {
                if(gcd < i) {
                    gcd = i;
                }
            }
        }
    System.out.println(gcd);
    
    
    }
}
