package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

/**
 * Write a function that takes the first Node in a linked list as argument
 * and (destructively) reverses the list,returning the first Node in the result.
 */
public class Ex30<Item> {
    public static void main(String[] args) {

    }

    private class Node {
        Item item;
        Node next;
    }

    public Node reverse(Node x) {
        if (x == null) return null;
        if (x.next == null) return x;
        Node y = x.next;
        Node rev = reverse(x.next);
        rev.next = x;
        x.next = null;
        return y;
    }
}
