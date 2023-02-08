/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenges;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author jakata
 */
public class AnagramStrings {

    public static void main(String[] args) {
        String string1 = "Race";
        String string2 = "Care";
        //convert strings to lower case
        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();
        if (string1.length() == string2.length()) {
            //convert strings to character array
            char[] charArray1 = string1.toCharArray();
            char[] charArray2 = string2.toCharArray();
            //sort arrays
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            System.out.println("Printing array 1..");
            for (char v : charArray1) {
                System.out.println(MessageFormat.format("{0}-{1} ", v, Integer.valueOf(v)));
            }
            System.out.println("Printing array 2..");
            for (char v : charArray2) {
                System.out.println(MessageFormat.format("{0}-{1} ", v, Integer.valueOf(v)));
            }
            if (Arrays.equals(charArray1, charArray2)) {
                System.out.println(MessageFormat.format("String {0} and {1} are anagram", string1, string2));
            } else {
                System.out.println(MessageFormat.format("String {0} and {1} are NOT anagram", string1, string2));
            }
        } else {
            System.out.println(MessageFormat.format("String {0} and {1} are NOT anagram", string1, string2));
        }
    }
}
