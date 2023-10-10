package com.moonheart.algs4.exercise.chapter3.SymbolTable;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class GPA {
    public static void main(String[] args) {
        ST<String, Double> st = new ST<>();
        st.put("A+", 4.33);
        st.put("A", 4.00);
        st.put("A-", 3.67);
        st.put("B+", 3.33);
        st.put("B", 3.00);
        st.put("B-", 2.67);
        st.put("C+", 2.33);
        st.put("C", 2.00);
        st.put("C-", 1.67);
        st.put("D", 1.00);
        st.put("F", 1.00);
        double sum = 0;
        int cnt = 0;
        In in = new In("input.txt");
        while (!in.isEmpty()) {
            String s = in.readString();
            if (!st.contains(s)) {
                System.out.println("the key" + s + " does not exists");
                break;
            }
            sum += st.get(s);
            cnt++;
        }
        double gpa = sum / cnt;
        System.out.println("The average grades for the student is: " + gpa);
    }
}
