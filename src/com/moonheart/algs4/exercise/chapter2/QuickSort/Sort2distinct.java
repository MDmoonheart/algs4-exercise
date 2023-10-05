package com.moonheart.algs4.exercise.chapter2.QuickSort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Sort2distinct {

    private static void sort(Comparable[] a) {
        int lo = 0, hi = a.length - 1;
        System.out.println(a.length);
        int i = lo, j = hi + 1;// i point to the left array, and j point to the right array
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j]))
                ; //if(j==lo) break; this is redundant since when j==lo, the less(v, a[--j]) always false.
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
    }

    private static void exch(Comparable[] a, int lo, int hi) {
        Comparable swap = a[lo];
        a[lo] = a[hi];
        a[hi] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        // display results again using select
        System.out.println(a.length);
        StdOut.println();
        Sort2distinct.sort(a);
        show(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
