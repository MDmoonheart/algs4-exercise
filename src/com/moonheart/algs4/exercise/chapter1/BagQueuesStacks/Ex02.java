package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Question:
 * Give the output printed by java Stack for the input
 * it was - the best - of times - - - it was - the - -
 */
public class Ex02 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (!str.equals("-")) {
                stack.push(str);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }

        }
        StdOut.println("\n(" + stack.size() + " left on the stack.)");
    }
}
