package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Stack<String> st = new Stack<>();
        while (!StdIn.isEmpty()) {
            st.push(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.print(st.pop() + " ");
        }
    }
}
