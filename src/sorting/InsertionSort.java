/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import fundamentals.StdOut;

/**
 *
 * @author KELVIN WARUI
 */
public class InsertionSort {

    public static void sort(Comparable a[]) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable current = a[i];
            int j = i - 1;
            while (j >= 0 && less(current, a[j])) {
                exchange(a, j + 1, j);
                j--;
            }
            a[j + 1] = current;
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void show(Comparable[] a) {
        // Print the array, on a single line.
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};//StdIn.readAllStrings();
        StdOut.println("Printing array before sorting...");
        show(a);
        sort(a);
        assert isSorted(a);
        StdOut.println("Printing sorted array...");
        show(a);
    }
}
