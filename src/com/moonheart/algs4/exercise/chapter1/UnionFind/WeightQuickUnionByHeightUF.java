package com.moonheart.algs4.exercise.chapter1.UnionFind;

import edu.princeton.cs.algs4.StdIn;

public class WeightQuickUnionByHeightUF {
    private int[] parent;
    private int[] height;
    private int n;
    private int count;

    public WeightQuickUnionByHeightUF(int n) {
        count = n;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i] = 0;
        }
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p > n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;

        // the tree tall stay the same since merging a new shorter tree cannot change the height of trees.
        if (height[pid] > height[qid]) {
            parent[qid] = pid;
        } else if (height[qid] > height[pid]) {
            parent[pid] = qid;
        } else {
            parent[pid] = qid;
            // link to the root node, the merged tree height increases by 1 since the two trees tall are the same
            height[qid]++;
        }
        count--;
    }


    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        while (parent[p] != p) {
            p = parent[p];
        }

        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        int height = StdIn.readInt();
        WeightQuickUnionByHeightUF uf = new WeightQuickUnionByHeightUF(height);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
            System.out.println("Union " + p + " " + q);
        }
        System.out.println("The component(s) of system: " + uf.count());
    }
}
