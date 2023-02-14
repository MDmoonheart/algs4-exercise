package com.moonheart.algs4.exercise.chapter1.UnionFind;

import edu.princeton.cs.algs4.StdIn;

public class QuickFindUF {
    private int[] parent;
    private int count;
    int n;

    public QuickFindUF(int n) {
        this.n = n;
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int count() {
        return this.count;
    }

    public int find(int p) {
        validate(p);
        return parent[p];
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p > n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public void union(int p, int q) {
        validate(p);
        validate(p);
        if (!connected(p, q)) {
            int pid = find(p);
            for (int j = 0; j < this.n; j++) {
                if (parent[j] == pid) parent[j] = find(q);
            }
            count--;
        }
    }

    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        int size = StdIn.readInt();
        QuickFindUF qf = new QuickFindUF(size);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            qf.union(p, q);
//            System.out.println("Union " + p + " " + q);
        }
        System.out.println("The component(s) of system: " + qf.count());
    }
}
