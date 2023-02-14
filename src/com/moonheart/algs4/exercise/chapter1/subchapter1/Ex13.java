package com.moonheart.algs4.exercise.chapter1.subchapter1;



public class Ex13 {
    public static void main(String[] args) {
        double[][] arr = {{1,2,3,4}, {2,3,4,5}};
        System.out.println(arr.length);
        printArr(arr);        
        printArr(transpose(arr));    
    }

    public static double[][] transpose(double[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        double[][] newArr = new double[m][n];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
               newArr[j][i] = arr[i][j];
            }
        }
        return newArr;
    }

    public static void printArr(double[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
            
        }
    }
}
