package com.moonheart.algs4.exercise.chapter1.UnionFind;

public class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int n;
    private int count;

    public WeightedQuickUnionUF(int n) {
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
        validate(p);
        validate(q);
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;

        if (size[pid] > size[qid]) {
            parent[qid] = pid;
            size[pid] += size[qid];
        } else {
            parent[pid] = qid;
            size[qid] += size[pid];
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

//    public static void main(String[] args) {
//        int size = StdIn.readInt();
//        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(size);
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//            uf.union(p, q);
//            System.out.println("Union " + p + " " + q);
//        }
//        System.out.println("The component(s) of system: " + uf.count());
//    }
}
