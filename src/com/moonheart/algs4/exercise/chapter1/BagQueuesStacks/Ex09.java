package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.3.9 Write a program that takes from standard input an expression without left parentheses
 * and prints the equivalent infix expression with the parentheses inserted. For
 * example, given the input:
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * your program should print
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ))
 */

public class Ex09 {
    public static void main(String[] args) {
        Stack<String> operators = new Stack<>();
        Stack<String> expressions = new Stack<>();
        String s = StdIn.readLine();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch.equals('+') || ch.equals('-') || ch.equals('*') || ch.equals('/')) {
                operators.push(String.valueOf(ch));
            } else if (!ch.equals(')')) {
                expressions.push(String.valueOf(ch));
            } else {
                String num1 = expressions.pop();
                String num2 = expressions.pop();
                String op = operators.pop();
                String tempString = "(" + num2 + op + num1 + ")";
                expressions.push(tempString);
            }
        }
        StdOut.println(expressions.pop());
    }
}
