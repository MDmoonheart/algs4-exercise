package com.moonheart.algs4.exercise.chapter1.subchapter1;

public class Ex10 {
    public static void main(String[] args) {
        boolean[][] arr = {
            {true, true, false},
            {false, true}
        };
        print2Darr(arr);
    }

    public static void print2Darr(boolean [][] arr) {
        int nRow = arr.length;
        for(int i = 1; i <=  nRow; i++) {
            int nCol = arr[i-1].length;
            for(int j = 1; j <= nCol; j++) {
                if (arr[i-1][j-1]) {
                    System.out.printf("the element of %d-th row %d-th column is: * \n", i, j );
                }
                else {
                    System.out.printf("the element of %d-th row %d-th column is:   \n", i, j );
                }
            }
        }
    }
}
