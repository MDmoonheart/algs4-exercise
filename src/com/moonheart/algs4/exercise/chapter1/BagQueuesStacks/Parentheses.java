package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Map;

public class Parentheses {
    public static void main(String[] args) {
        String s;
        s = StdIn.readLine();
        String ans = isValid(s) ? "true" : "false";
        StdOut.println(ans);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('[', ']');
        parentheses.put('{', '}');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (parentheses.containsKey(ch)) {
                st.push(ch);
            } else if (parentheses.containsValue(ch)) {
                if (!parentheses.get(st.pop()).equals(ch)) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }


}
