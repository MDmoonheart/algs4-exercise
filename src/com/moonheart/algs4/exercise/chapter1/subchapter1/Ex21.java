package com.moonheart.algs4.exercise.chapter1.subchapter1;
import java.util.ArrayList;

import edu.princeton.cs.algs4.*;
import java.util.List;

public class Ex21 {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        while(StdIn.hasNextLine()) {
            name.add(StdIn.readString());
            System.out.println(1);
            first.add(StdIn.readInt());
            System.out.println(2);
            second.add(StdIn.readInt());
            System.out.println(3);
        }
        StdOut.println("name" + "first" + "second" + "div");
        int n = name.size();
        for(int j = 0; j < n; j++) {
            StdOut.print(name.get(j));
            StdOut.print(first.get(j));
            StdOut.print(second.get(j));
            StdOut.printf("%.3f" + "\n", first.get(j) / second.get(j));
        }
    }
}
