package com.moonheart.algs4.exercise.chapter2.PriorityQueue;

import edu.princeton.cs.algs4.StdIn;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public MaxPQ(Key[] a) {
        this(a.length);
        for (int i = 0; i < a.length; i++) {
            pq[i + 1] = a[i];
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = max();
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    public int size() {
        return N;
    }

    public Key max() {
        if (isEmpty()) return null;
        return pq[1];
    }

    public void printArray() {
        Key[] a = (Key[]) new Comparable[N];
        for (int i = 1; i <= N; i++) {
            System.out.print(pq[i]);
        }
    }

    private void swim(int k) {
        while (k > 1) {
            if (!less(k / 2, k)) break;
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k <= 1 + (N - 1) / 2) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int k, int v) {
        Key temp = pq[k];
        pq[k] = pq[v];
        pq[v] = temp;
        temp = null; //prevent loitering
    }

    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) <= 0;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(11);

        while (!StdIn.isEmpty()) {
            Integer i = StdIn.readInt();
            pq.insert(i);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(pq.delMax());
        }
    }

}
