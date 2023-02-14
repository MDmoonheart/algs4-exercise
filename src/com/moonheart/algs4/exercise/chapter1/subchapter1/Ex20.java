package com.moonheart.algs4.exercise.chapter1.subchapter1;
import java.lang.Math;
public class Ex20 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(logFactorial(n));
    }

    public static double logFactorial(int N) {
        if(N == 1) {
            return 0;
        }
        return Math.log(N) + logFactorial(N -1);
    }


}
