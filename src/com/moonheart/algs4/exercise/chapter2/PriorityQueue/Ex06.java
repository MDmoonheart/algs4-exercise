package com.moonheart.algs4.exercise.chapter2.PriorityQueue;

import edu.princeton.cs.algs4.StdIn;

/**
 * 2.4.6 Using the conventions of Exercise 2.4.1, give the sequence of heaps produced
 * when the operations P R I O * R * * I * T * Y * * * Q U E * * * U * E are
 * performed on an initially empty max-oriented heap.
 */
public class Ex06 {
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>(20);

        String[] s = StdIn.readAllStrings();
        for (String str : s) {
            if (str.equals("*")) {
                pq.delMax();
            } else {
                pq.insert(str);
            }
        }
        pq.printArray();
    }
}
