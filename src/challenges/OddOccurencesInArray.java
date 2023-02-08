/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KELVIN WARUI
 */
public class OddOccurencesInArray {

    public static int solution(int[] A) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int oddElement = 0;
        if (A.length % 2 != 0 && (A.length > 0 && A.length <= 1_000_000)) {
            for (int ctr = 0; ctr < A.length; ctr++) {
                if (A[ctr] > 0 && A[ctr] <= 1_000_000 && frequencyMap.containsKey(A[ctr])) {
                    frequencyMap.put(A[ctr], frequencyMap.get(A[ctr]) + 1);
                } else {
                    frequencyMap.put(A[ctr], 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    oddElement = entry.getKey();
                    break;
                }
            }
        }

        return oddElement;
    }

    public static void main(String[] args) {
        int oddElement = solution(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println("Odd element is " + oddElement);
    }
}
