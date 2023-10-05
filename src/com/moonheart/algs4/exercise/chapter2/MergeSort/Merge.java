package com.moonheart.algs4.exercise.chapter2.MergeSort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Merge {

    private static Comparable[] aux;

    private Merge() {
    } // This class should not be instantiated.

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        show(a);
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);// sort left one
        sort(a, mid + 1, hi);// sort right one
        merge(a, lo, mid, hi);
    }

    /*
     * helper method
     */
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        /**
         * k points to the current position
         * i points to the left array
         * j points to the right array
         */
        int i=lo, j=mid+1;
        for(int k=lo; k <= hi; k++){
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
        a[j] = a[i];
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
