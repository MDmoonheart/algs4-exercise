package com.moonheart.algs4.exercise.chapter4.Digraph;

import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.*;

public class Topological {
    private Iterable<Integer> order;  // topological order
    private int[] rank;               // rank[v] = rank of vertex v in order
    Stack<Integer> reversePost;

    public Topological(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            rank = new int[G.V()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
        }
    }

    public boolean isDAG() {
        return order == null;
    }

    public Iterable<Integer> order() {
    }

    public static void main(String[] args) {
        String filename = args[0];
        String delimiter = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, delimiter);
        Topological topological = new Topological(sg.digraph());
        for (int v : topological.order()) {
            StdOut.println(sg.nameOf(v));
        }
    }

}
