/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenges;

import java.util.Arrays;

/**
 *
 * @author KELVIN WARUI
 */
public class MissingInteger {

    public static int solution(int[] A) {
        int size = A.length;
        if (size < 1 || size > 1_000_000) {
            return 1;
        }
        Arrays.sort(A);
        int min = 1;
        for (int x = 0; x < size; x++) {
            if (A[x] < -1_000_000 || A[x] > 1_000_000) {
                return min;
            }
            if (min == A[x]) {
                min++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int min = solution(new int[]{-1,-3,1, 2, 3});
        System.out.println("Min is " + min);
    }
}
