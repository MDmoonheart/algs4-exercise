package com.moonheart.algs4.exercise.chapter1.subchapter2;

import edu.princeton.cs.algs4.Interval2D;

import java.net.InetAddress;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ex03 {
    public static void main(String[] args) {
        System.out.println(mystery("worinle"));

    }

    private static void getInterval2Ds(Interval2D[] inter) {
        for(int i = 0; i < inter.length; i++) {
            double a1 = StdRandom.uniform();
            double b1 = StdRandom.uniform();
            double a2 = StdRandom.uniform();
            double b2 = StdRandom.uniform();
            
            double max_value1 = a1 > b1 ? a1 : b1;
            double min_value1 = a1 > b1 ? b1 : a1;
            
            double max_value2 = a2 > b2 ? a2 : b2;
            double min_value2 = a2 > b2 ? b2 : a2;
            
            Interval1D int1 = new Interval1D(min_value1, max_value1);
            Interval1D int2 = new Interval1D(min_value2, max_value2);

            inter[i] = new Interval2D(int1, int2);
        }
    }

    public static String mystery(String s)
    {
    int N = s.length();
    if (N <= 1) return s;
    String a = s.substring(0, N/2);
    String b = s.substring(N/2, N);
    return mystery(b) + mystery(a);
    }
}
