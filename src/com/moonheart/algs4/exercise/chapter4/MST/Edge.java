package com.moonheart.algs4.exercise.chapter4.MST;

import edu.princeton.cs.algs4.StdOut;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    /**
     * @param v the index of one vertex of the edge
     * @return the index of the other vertex
     */
    public int other(int v) {
        if (this.v == v) return w;
        else if (this.v == w) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }


    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }

    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }

    public static void main(String[] args) {
        Edge e = new Edge(12, 34, 5.67);
        StdOut.println(e);
    }
}
