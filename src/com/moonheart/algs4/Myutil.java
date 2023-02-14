package com.moonheart.algs4;

public class Myutil {

    public static <T> void print2Darr(T[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");

        }
    }

    public static <T> void printArr(T[] arr) {
        System.out.print('[');
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.print(']');
    }

}
