package com.moonheart.algs4.exercise.chapter1.subchapter1;

import edu.princeton.cs.algs4.*;

public class Ex24 {
    public static void main(String[] args) {
        int p = StdIn.readInt();
        int q = StdIn.readInt();
        System.out.println(gcd(p, q));
    }

    public static int gcd(int p , int q) {
        if(q == 0) return p ;
        int r = p % q;
        return gcd(q, r);
    }

    
}
