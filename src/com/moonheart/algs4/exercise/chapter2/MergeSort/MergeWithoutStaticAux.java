package com.moonheart.algs4.exercise.chapter2.MergeSort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * Use of a static array like aux[] is inadvisable in library software because multiple 
 * clients might use the class concurrently. Give an implementation of Merge.java that 
 * does not use a static array.
 */
public class MergeWithoutStaticAux {

    private MergeWithoutStaticAux() {} // no instance of the class allowed

    
    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        sort(a, aux, 0, n-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
    

    // helper method
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        /**
         * k points to the current position
         * i points to the left array
         * j points to the right array
         */
        int i=lo, j=mid+1;
        for(int k=lo; k <= hi; k++){
            aux[k] = a[k];
        }
        for(int k=lo; k<=hi; k++) {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * entry fucntion
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        show(a);
    }

}
