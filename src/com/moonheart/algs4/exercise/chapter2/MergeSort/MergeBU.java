/**
 * The bottom-up merge sort implementation
 */
package com.moonheart.algs4.exercise.chapter2.MergeSort;

import java.lang.Math;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeBU {

    private static Comparable[] aux;

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        show(a);
    }

    public static void sort(Comparable[] a) { 
        // implement by youself
        int N = a.length;
        a = new Comparable[N];
        for(int sz=1; sz < N-1; sz=sz+sz)
            for (int lo=0; lo < N-sz; lo+=sz+sz)
                merge(a, lo, lo+sz-1, Math.min(lo+sz, N-sz));
    }
    

    /*
     * helper method
     */
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
         // k points to the current position
         // i points to the left array
         // j points to the right array
        int i = lo, j = mid + 1; //  create pointer to the lo and middle position
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++]; // left array exhausted
            else if (j > hi) a[k] = aux[i++]; // right array exhausted
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Comparable[] a) {
        for (Comparable o : a) {
            StdOut.print(o);
        }
    }
}
