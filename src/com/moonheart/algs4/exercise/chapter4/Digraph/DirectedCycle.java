package com.moonheart.algs4.exercise.chapter4.Digraph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {

    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v] && cycle != null)
                dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) return;

            if (!marked[v]) {
                edgeTo[w] = v;
                dfs(G, v);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int s = v; s != w; s = edgeTo[s]) {
                    cycle.push(s);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;

    }

    public static void main(String[] args) {

    }
}
