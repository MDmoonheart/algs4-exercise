package com.moonheart.algs4.exercise.chapter1.subchapter1;

public class Ex09 {
    public static void main(String[] args) {
        String ans = toString(320);
        System.out.println(ans);

    }

    public static String toString(int N) {
        String s = "";
        for(int n = N; n > 0; n /= 2 ) {
            s = (n % 2) + s;
        }
        return s;
    }
}
