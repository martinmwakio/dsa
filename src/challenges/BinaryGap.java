/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenges;

/**
 *
 * @author KELVIN WARUI
 */
public class BinaryGap {

    public static int solution(int N) {
        int finalGap = 0;
        int tempGap = 0;
        if (N > 0 && N <= 2_147_483_647) {
            char[] binaryString = Integer.toBinaryString(N).toCharArray();
            for (int x = 0; x < binaryString.length; x++) {
                if (binaryString[x] == '1') {
                    if (tempGap > finalGap) {
                        finalGap = tempGap;
                    }
                    tempGap = 0;
                } else {
                    tempGap++;
                }
            }

        }
        return finalGap;
    }

    public static void main(String[] args) {
        int maxGap = solution(15);
        System.out.println("Max gap is " + maxGap);
    }
}
