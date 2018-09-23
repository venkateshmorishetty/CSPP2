import java.io.File;
import java.util.Scanner;
/**
 * Class for stringmatch.
 */
class Stringmatch {
	/**
	 * { str1 }.
	 */
	private String str1 = "";
	/**
	 * { str2 }.
	 */
	private String str2 = "";
	/**
	 * { str }.
	 */
	private String str = "";
	/**
	 * { res }.
	 */
	private double res;
	/**
	 * Constructs the object.
	 *
	 * @param      file1  The file 1
	 * @param      file2  The file 2
	 */
	public Stringmatch(final File file1, final File file2) {
		try {
			Scanner sc = new Scanner(file1);
			while (sc.hasNext()) {
				str1 += sc.nextLine();
			}
			sc  = new Scanner(file2);
			while (sc.hasNext()) {
				str2 += sc.nextLine();
			}
			for (int i = 0; i < str2.length(); i++) {
				for (int j = i + 1; j <= str2.length(); j++) {
					if (str1.contains(str2.substring(i, j))) {
						if (str2.substring(i, j).length() > str.length()) {
							str = str2.substring(i, j);
						}
					}
				}
			}
			if (file1.getName().equals(file2.getName())) {
				res = 100;
				System.out.format("%13.1f", res);
			} else {
				double n = str.length() * 2 * 100;
				double d = str1.length() + str2.length();
				res = Math.round(n / d);
				System.out.format("%13.1f", res);
			}
		} catch(Exception e) {
			System.out.println("FILE NOT FOUND");
		}	
	}
	public double getResult() {
		return res;
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
	 * { sol }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		try {
		Scanner sc = new Scanner(System.in);
		String foldername = sc.nextLine();
		File dir = new File(foldername);
		File[] fileslist = dir.listFiles();
		double maximum = 0;
		String f1 = "";
		String f2 = "";
        System.out.print("             ");
		for (int i = 0; i < fileslist.length - 1; i++) {
			System.out.print(fileslist[i].getName() + "    ");
		}
		System.out.print(fileslist[fileslist.length - 1].getName() + " ");
		System.out.println();
		for (int i = 0; i < fileslist.length; i++) {
			System.out.print(fileslist[i].getName());
			for (int j = 0; j < fileslist.length; j++) {
				Stringmatch sm = new Stringmatch(fileslist[i],
					fileslist[j]);
				double res = sm.getResult();
				if (res > maximum && !(fileslist[i].getName()
					.equals(fileslist[j].getName()))) {
					maximum = res;
					f1 = fileslist[i].getName();
					f2 = fileslist[j].getName();

				}
			}
			System.out.print(" ");
			System.out.println();
		}
		System.out.println("Maximum similarity is between "
			+ f1 + " and " + f2);
		} catch (Exception e) {
			System.out.println("Empty Directory");
		}

	}
}