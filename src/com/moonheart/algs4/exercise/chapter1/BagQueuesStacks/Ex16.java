package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class Ex16 {
    public static void main(String[] args) {
        String filename = args[0];
        Date[] dates = readDates(filename);
        for (Date d : dates) System.out.println(d);
    }

    public static Date[] readDates(String filename) {
        In in = new In(filename);
        Queue<Date> qd = new Queue<>();
        while (!in.isEmpty()) {
            String d = in.readString();
            Date date = new Date(d);
//            StdOut.println("adding dates: " + date);
            qd.enqueue(date);
        }
        int n = qd.size();
        Date[] dates = new Date[n];
        for (int i = 0; i < n; i++) {
            dates[i] = qd.dequeue();
        }
        return dates;
    }

}


