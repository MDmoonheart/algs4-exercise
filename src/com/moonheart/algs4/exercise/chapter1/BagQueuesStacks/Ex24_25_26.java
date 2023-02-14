package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

/**
 * 1.3.24 Write a method removeAfter() that takes a linked-list Node as argument and
 * removes the node following the given one (and does nothing if the argument or the next
 * field in the argument node is null).
 * <p>
 * 1.3.25 Write a method insertAfter() that takes two linked-list Node arguments and
 * inserts the second after the first on its list (and does nothing if either argument is null).
 * <p>
 * 1.3.26 Write a method remove() that takes a linked list and a string key as arguments
 * and removes all of the nodes in the list that have key as its item field.
 */


public class Ex24_25_26 {

    public static void main(String[] args) {

    }

    public static <Item> void removeAfter(Node<Item> node) {
        if (node.next != null) {
            node.next = node.next.next;
        }
    }

    public static <Item> void insertAfter(Node<Item> first, Node second) {
        if (first != null && second != null) {
            first.next = second;
        }
    }


}

