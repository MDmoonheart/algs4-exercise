/******************************************************************************
 *  Compilation:  javac QuickUnionUF.java
 *  Execution:  java QuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *  Quick-union algorithm.
 *
 ******************************************************************************/


package com.moonheart.algs4.exercise.chapter1.UnionFind;


import edu.princeton.cs.algs4.StdIn;

public class QuickUnionUF {
    private int[] parent; //parent[i] = parent of i
    private int count;

    /**
     * Initializes an empty union-find data structure with
     * {@code n} elements {@code 0} through {@code n-1}.
     * Initially, each element is in its own set.
     *
     * @param n the number of elements
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public QuickUnionUF(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets (between {@code 1} and {code n}
     */
    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int root = find(p);
        if (!connected(p, q)) {
            parent[root] = find(q);
            count--;
        }
    }

    public int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public static void main(String[] args) {
        int size = StdIn.readInt();
        QuickUnionUF qf = new QuickUnionUF(size);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            qf.union(p, q);
            System.out.println("Union " + p + " " + q);
        }
        System.out.println("The component(s) of system: " + qf.count());
    }


}
