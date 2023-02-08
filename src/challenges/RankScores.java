/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenges;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author KELVIN WARUI
 */
public class RankScores {

    public static void transform(int[] arr) {
        // create an empty `TreeMap`
        Map<Integer, Integer> map = new TreeMap<>();
        // store (element, index) pair in `TreeMap`
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        // keys are stored in sorted order in `TreeMap`
        // rank starts from 1
        int rank = 1;
        // iterate through the map and replace each element with its rank
        for (var val : map.values()) {
            arr[val] = rank++;
        }
    }

    public static void main(String[] args) {
        int[] A = {10, 8, 15, 12, 6, 20, 1,8};
        // transform the array
        transform(A);
        // print the transformed array
        System.out.println(Arrays.toString(A));
    }
}
