package com.moonheart.algs4.exercise.chapter1.subchapter1;

public class Ex14 {
    public static void main(String[] args) {
        int n = 1;
        System.out.println(lg(n));
    }

    public static int lg(int N) {
        int x = 0;
        int temp = 1;
        while(true) {
            if(temp > N) {
                return x - 1;
            }
            x ++ ;
            temp = temp * 2;
            }
        }
}

