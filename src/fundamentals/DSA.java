/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals;

import java.util.Arrays;

/**
 *
 * @author KELVIN WARUI
 */
public class DSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DSA obj = new DSA();
        System.out.println("Reversing array....");
        obj.reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        obj.formatOutput(new String[]{"7", "400", "700"});
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("7 is at index " + obj.binarySearch(7, arr));
    }

    private void formatOutput(String[] args) {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int i = 0; i < N; i++) {
            double x = Math.random() * 4000;
            System.out.printf("%11.4f\n", x);
        }
    }
/*Searches for an element in an integer array. Returns:
    (a) Index of the element if found
    (b) -1 if element does not exist in this array
*/
    private int binarySearch(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
/*Reverses an integer array */
    private void reverseArray(int arr[]) {
        int N = arr.length;
        for (int x = 0; x < N / 2; x++) {
            int temp = arr[x];
            arr[x] = arr[N - 1 - x];
            arr[N - 1 - x] = temp;
        }
        for (int elem : arr) {
            System.out.println(elem);
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
