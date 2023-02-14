package com.moonheart.algs4.exercise.chapter3.subchapter1;


import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdIn;

public class Ex01 {
    public static void main(String[] args) {
        BinarySearchST<String, Double> scoresMap = new BinarySearchST<>(2);
        scoresMap.put("A+", 4.33);
        scoresMap.put("A", 4.00);
        scoresMap.put("A-", 3.67);
        scoresMap.put("B+", 3.33);
        scoresMap.put("B", 3.00);
        scoresMap.put("B-", 2.67);
        scoresMap.put("C+", 2.33);
        scoresMap.put("C", 2.00);
        scoresMap.put("C-", 1.67);
        scoresMap.put("D", 1.00);
        scoresMap.put("F", 0.00);

        //Read the inputs from stdIn
        String[] grades = StdIn.readAllLines();
        Double sum = .0;
        for(String grade : grades) {
            sum += scoresMap.get(grade);
        }
        Double gpa = sum / grades.length;
        System.out.printf("GPA: %.2f", gpa);
    }
}
