package com.moonheart.algs4.exercise.chapter1.subchapter1;

import java.util.*;

public class Ex15 {
    public static void main(String[] args) {
        int[] arr = {3,3,2,5,7};
        int[] out = histogram(arr, 8);
        for(int j : out) {
            System.out.println(j);
        }
    }

    public static int[] histogram(int[] arr, int M) {
        Arrays.sort(arr);
        int[] ans = new int[M];
        int ptr = 0;
        for(int i = 0; i < M; i++) {
            for(int j = ptr; j < arr.length; j ++) {
                if(arr[j] > i) {
                    ptr = j;
                    break;
                }
                if(arr[j] == i) {
                    ans[i] ++;
                }
            }
        }
        return ans;
    }

}
