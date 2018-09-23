import java.util.Scanner;
import java.util.HashMap;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class for plagiarism.
 */
class Plagiarism {
    /**
     * { function_description }.
     *
     * @param      filename  The filename
     *
     * @return     { description_of_the_return_value }
     */
    public HashMap map(final File filename) {
        /**
         * { var_description }.
         */
        HashMap<String, Integer> hm = new HashMap();
        String data = "";
        try {
            BufferedReader b = new BufferedReader(new FileReader(filename));
            String str = b.readLine();
            while (str != null) {
                data += str;
                str = b.readLine();
            }
            Pattern r = Pattern.compile("[^a-z A-Z 0-9]");
            Matcher m = r.matcher(data);
            String temp = m.replaceAll("").replace(".", " ").toLowerCase();
            String[] line = temp.split(" ");
            if (temp.length() > 0) {
            for (int i = 0; i < line.length; i++) {
                if (hm.containsKey(line[i])) {
                    hm.put(line[i], hm.get(line[i]) + 1);
                } else {
                    hm.put(line[i], 1);
                }
            }
            }
        }  catch (Exception e) {
            System.out.println(e);
        }
        return hm;
    }
    /**
     * { function_description }.
     *
     * @param      hm1   The hm 1
     * @param      hm2   The hm 2
     *
     * @return     { description_of_the_return_value }
     */
    public double similarity(final HashMap<String, Integer> hm1,
        final HashMap<String, Integer> hm2) {
        double frequencyvector1 = 0, frequencyvector2 = 0;
        double similarity;
        int dotproduct = 0;
        for (int i : hm1.values()) {
            frequencyvector1 = frequencyvector1 + Math.pow(i, 2);
        }
        frequencyvector1 = Math.sqrt(frequencyvector1);
        for (int i : hm2.values()) {
            frequencyvector2 = frequencyvector2 + Math.pow(i, 2);
        }
        frequencyvector2 = Math.sqrt(frequencyvector2);
        for (String i : hm1.keySet()) {
            if (hm2.containsKey(i)) {
                dotproduct = dotproduct + hm1.get(i) * hm2.get(i);
            }
        }
        similarity = dotproduct / (frequencyvector2 * frequencyvector1);
        return similarity;
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
        Scanner sc = new Scanner(System.in);
        String foldername;
        long maximum = 0;
        try {
            foldername = sc.nextLine();
        } catch (Exception e) {
            System.out.println("empty directory");
            return;
        }
        File dir = new File(foldername);
        File[] filearray = dir.listFiles();
        HashMap[] hashmaparray = new HashMap[filearray.length];
        Plagiarism p = new Plagiarism();
        int temp = 0;
        final int except = 100;
        File file1 = null, file2 = null;
        long[][] result = new long[filearray.length][filearray.length];
        for (File print : filearray) {
            hashmaparray[temp] = p.map(print);
            temp++;
        }
        for (int i = 0; i < filearray.length; i++) {
            for (int j = 0; j < filearray.length; j++) {
                result[i][j] = Math.round(p.similarity(hashmaparray[i],
                    hashmaparray[j]) * except);
                if (maximum < result[i][j]
                    && result[i][j] != except) {
                    maximum = result[i][j];
                    file1 = filearray[i];
                    file2 = filearray[j];
                }
            }
        }
        System.out.print("      \t\t");
        for (int i = 0; i < filearray.length; i++) {
            System.out.print(filearray[i].toString()
                .split("\\\\")[1] + "\t");
        }
        System.out.println();
        for (int i = 0; i < filearray.length; i++) {
            System.out.print(filearray[i].toString()
                .split("\\\\")[1] + "\t");
            for (int j = 0; j < filearray.length; j++) {
                System.out.print(result[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("Maximum similarity is between "
            + file1.toString().split("\\\\")[1] + " and "
            + file2.toString().split("\\\\")[1]);
    }
}
