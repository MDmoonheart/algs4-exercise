package com.moonheart.algs4.exercise.chapter3.SymbolTable;
/**
 * 3.1.3 Develop a symbol-table implementation OrderedSequentialSearchST that
 * uses an ordered linked list as the underlying data structure to implement our ordered
 * symbol-table API.
 */

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {

    private int n = 0;

    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private Node first; // the first node of the LinkedList
    private Node dummy = new Node(null, null, first);

    public void put(Key key, Value value) {
        if (isEmpty()) {
            first = new Node(key, value, null);
            n++;
            return;
        }
        first = put(first, key, value);

    }

    private Node put(Node node, Key key, Value value) {
        if (node.key.compareTo(key) == 0) {
            node.val = value;
            return node;
        }
        if (node.key.compareTo(key) < 0) {
            if (node.next == null) {
                node.next = new Node(key, value, null);
                n++;
            }
            node.next = put(node.next, key, value);
            return node;
        } else {
            n++;
            return new Node(key, value, node);
        }
    }


    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("the key is null for get()");
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) == 0) return x.val;
        }
        return null;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("the key is null for contains()");
        return (get(key) == null);
    }

    public void delete(Key key) {
        if (!contains(key)) throw new IllegalArgumentException("the key does not exists");
        first = delete(first, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;
        if (node.key.compareTo(key) == 0) {
            n--;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Key min() {
        if (isEmpty()) return null;
        return first.key;
    }

    public Key max() {
        if (isEmpty()) return null;
        Node x = first;
        while (x.next != null) x = x.next;
        return x.key;
    }

    // largest key less than or equal to key
    public Key floor(Key key) {
        if (isEmpty()) return null;
        if (first.next == null) {
            if (first.key.compareTo(key) <= 0) return first.key;
            else return null;
        }
        Node head = first;
        Node tail = first.next;
        while (tail != null) {
            if (head.key.compareTo(key) <= 0 && tail.key.compareTo(key) > 0) return head.key;
            tail = tail.next;
            head = head.next;
        }
        return head.key;
    }

    public Key ceiling(Key key) {
        if (isEmpty()) return null;
        if (first.next == null) {
            if (first.key.compareTo(key) >= 0) return first.key;
            else return null;
        }
        Node head = first;
        Node tail = first.next;
        if (head.key.compareTo(key) >= 0) return head.key;
        while (tail != null) {
            if (head.key.compareTo(key) < 0 && tail.key.compareTo(key) >= 0) return tail.key;
            tail = tail.next;
            head = head.next;
        }
        return null; //neve happen
    }

    public int rank(Key key) {
        int rnk = 0;
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(key) < 0) rnk++;
            else break;
        }
        return rnk;
    }

    // key of rank k
    public Key select(int k) {
        if (isEmpty()) return null;
        Node x = first;
        for (int i = 1; i < k; i++) {
            if (x == null) return null;
            x = x.next;
        }
        return x.key;
    }

    public void delelteMin() {
        if (isEmpty()) return;
        first = first.next;
        n--;
    }

    public void deleteMax() {
        if (isEmpty()) return;
        if (first.next == null) {
            first = null;
            n--;
            return;
        }
        Node x = first;
        while (x.next.next != null) x = x.next;
        x.next = null;
        n--;
    }

    public int size(Key lo, Key hi) {
        return rank(hi) - rank(lo) + 1;
    }

    public int size() {
        return n;
    }

    Iterable<Key> keys(Key lo, Key hi) {
        ArrayList<Key> arr = new ArrayList<>();
        for (Node x = first; x != null; x = x.next) {
            if (x.key.compareTo(lo) >= 0 && x.key.compareTo(hi) <= 0) arr.add(x.key);
        }
        return arr;
    }

    Iterable<Key> keys() {
        ArrayList<Key> arr = new ArrayList<>();
        for (Node x = first; x != null; x = x.next) {
            arr.add(x.key);
        }
        return arr;
    }

    public static void main(String[] args) {
        OrderedSequentialSearchST<String, Integer> st = new OrderedSequentialSearchST<>();
        int cnt = 1;
        while (!StdIn.isEmpty()) {
            st.put(StdIn.readString(), cnt);
            cnt++;
        }
        for (String ch : st.keys()) {
            System.out.println(ch + " " + st.get(ch));
        }
    }

}



