package com.moonheart.algs4.exercise.chapter3.BST;

/**
 * 3.2.10 Write a test client TestBST.java for use in testing the implementations of
 * min(), max(), floor(), ceiling(), select(), rank(), delete(), deleteMin(),
 * deleteMax(), and keys() that are given in the text. Start with the standard indexing
 * client given on page 370. Add code to take additional command-line arguments, as
 * appropriate.
 */

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestBST {
    public static void main(String[] args) {
        BST<String, Integer> st;
        st = new BST<String, Integer>();
        In in = new In(args[0]);
        for (int i = 0; !in.isEmpty(); i++) {
            String key = in.readString();
            st.put(key, i);
        }
        StdOut.println("the min key value is " + st.min() + ":" + st.get(st.min()));
        StdOut.println("the max key value is " + st.max() + ":" + st.get(st.max()));
        StdOut.println("the floor of G is " + st.floor("G"));
        StdOut.println("the ceiling of G is " + st.ceiling("G"));
        StdOut.println("the sixth key is " + st.select(6));
        StdOut.println("the rank of G is " + st.rank("G"));
        StdOut.println("before deleting the key S: " + "contains key S: " + st.contains("S"));
        st.delete("S");
        StdOut.println("after deleting the key S: " + "contains key S: " + st.contains("S"));
        st.deleteMin();
        StdOut.println("after deleting the min key: " + "contains min key: " + st.contains("A"));
        st.deleteMax();
        StdOut.println("after deleting the max key: " + "contains max key: " + st.contains("X"));

    }


}
