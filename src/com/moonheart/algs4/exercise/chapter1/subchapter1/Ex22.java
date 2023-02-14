package com.moonheart.algs4.exercise.chapter1.subchapter1;

import java.util.Arrays;

public class Ex22 {
    public static void main(String[] args) {
        int [] a = {2,3,4,1,23,5};
        Arrays.sort(a);
        System.out.println(rank(5, a));
     }

    public static int rank(int key, int[] a) { 
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) { 
        // Index of key in a[], if present, is not smaller than lo
        // and not larger than hi.
        depth ++;
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        for(int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.println("lo is: " + lo + "" + " hi is: " + hi + "");
        if (key < a[mid]) return rank(key, a, lo, mid - 1, depth);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth);
        else return mid;
    }
}