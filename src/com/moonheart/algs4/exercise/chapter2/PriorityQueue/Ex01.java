package com.moonheart.algs4.exercise.chapter2.PriorityQueue;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdIn;

public class Ex01 {
    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>();
        String[] strs = StdIn.readAllStrings();
        for (String s : strs) {
            if (!s.equals("*")) pq.insert(s);
            else System.out.print(pq.delMax());
        }
    }
}
