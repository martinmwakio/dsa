/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenges;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author KELVIN WARUI
 */
public class RankArrayElement {

    public static void arrayRank(int[] arr) {

        System.out.println("Given array: " + Arrays.toString(arr));
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 1;
        int prev = temp[0];
        map.put(prev, index);
        for (int i = 1; i < arr.length; i++) {
            if (prev != temp[i]) {
                index++;
            }
            map.put(temp[i], index);
            prev = temp[i];
        }
        for (int i = 0; i < arr.length; i++) {
            temp[i] = map.get(arr[i]);
        }
        System.out.println("Rank: " + Arrays.toString(temp));
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        arrayRank(new int[]{22, 11, 44, 66, 55});
        arrayRank(new int[]{15, 12, 11, 10, 9});
        arrayRank(new int[]{10, 20, 30, 40, 50});
        arrayRank(new int[]{10, 10, 10, 10, 20});
    }
}
