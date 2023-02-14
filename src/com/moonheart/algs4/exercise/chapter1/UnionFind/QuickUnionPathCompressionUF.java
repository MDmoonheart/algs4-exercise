package com.moonheart.algs4.exercise.chapter1.UnionFind;

import edu.princeton.cs.algs4.StdIn;

public class QuickUnionPathCompressionUF {
    private int[] parent;
    private int[] size;
    private int n;
    private int count;

    public QuickUnionPathCompressionUF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p > n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public void union(int p, int q) {
        int root = find(p);
        if (!connected(p, q)) {
            parent[root] = find(q);
            count--;
        }
    }


    public int count() {
        return count;
    }

    public int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }

        while (parent[p] != p) {
            int temp = parent[p];
            parent[p] = root;
            p = temp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        int size = StdIn.readInt();
        QuickUnionPathCompressionUF uf = new QuickUnionPathCompressionUF(size);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            System.out.println("Union " + p + " " + q);
        }
        System.out.println("The component(s) of system: " + uf.count());
    }
}

