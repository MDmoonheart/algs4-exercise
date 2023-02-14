package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;


/**
 * 1.3.20 Write a method delete() that takes an int argument k and deletes the kth element
 * in a linked list, if it exists.
 * <p>
 * 1.3.21 Write a method find() that takes a linked list and a string key as arguments
 * and returns true if some node in the list has key as its item field, false otherwise.
 */

import java.util.Iterator;

public class Ex20_21<Item extends Comparable<Item>> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;

    }

    private Node head;
    private int n;

    public Ex20_21() {
        this.n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        if (isEmpty()) {
            head = new Node();
            head.item = item;
        } else {
            Node current;
            for (current = head; current.next != null; current = current.next) ;

            Node newNode = new Node();
            newNode.item = item;
            current.next = newNode;
        }
        n++;
    }


    public void delete(int k) {
        int i;
        Node curr = head;
        for (i = 0; i < k - 2; ++i) {
            if (curr.next == null) {
                System.out.println("cease");
                return;
            }
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
            n--;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = (Item) current.item;
            current = current.next;

            return item;
        }
    }

    public boolean find(Item item) {
        Node curr = head;
        while (curr.next != null) {
            if (curr.item.equals(item)) return true;
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Ex20_21<String> ex = new Ex20_21<>();
        ex.add("I");
        ex.add("am");
        ex.add("a");
        ex.delete(1);
        for (String i : ex) System.out.println(i);
        System.out.println(ex.recursiveMax(ex.head));
    }

    // exercise 26
    public void remove(Node first, Item item) {
        if (first == null) return;
        if (first.next == null) {
            if (first.equals(item)) first = null;
        }
        Node curr = first;

        while (curr.next != null) {
            if (curr.next.equals(item)) {
                curr.next = curr.next.next;
            }
        }
        n--;
    }

    // exercise 27
    public Item max(Node first) {
        Item maxItem = first.item;
        Node curr = first.next;
        while (curr != null) {
            if (curr.item.compareTo(maxItem) > 0) maxItem = curr.item;
            curr = curr.next;
        }
        return maxItem;
    }

    public Item recursiveMax(Node first) {
        if (first == null) return null;
        Item temp = recursiveMax(first.next);
        if (temp == null || (first.item.compareTo(temp) > 0)) {
            return first.item;
        } else return recursiveMax(first.next);

    }


}
