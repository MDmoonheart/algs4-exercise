package com.moonheart.algs4.exercise.chapter2.PriorityQueue;

/**
 * Design a linear-time certification algorithm to check whether an array pq[] is
 * a min-oriented heap.
 */
public class Ex15<T extends Comparable<T>> {
    private final T[] pq;
    private final int N;

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1, 2, 2, 3, 4, 5, 3, 1};
        Ex15<Integer> ex = new Ex15<>(ints);
        System.out.println(ex.minHeapOrder());

    }

    public Ex15(T[] pq) {
        this.pq = pq;
        this.N = pq.length - 1;
    }

    public boolean minHeapOrder(int head) {
        int left = head * 2; // left child reference
        if (left + 1 > N) return true;
        int right = head * 2 + 1; // right child reference
        if (less(pq[left], pq[head]) || less(pq[right], pq[left])) return false;
        boolean leftOrder = minHeapOrder(left);
        boolean rightOrder = minHeapOrder(right);
        return leftOrder && rightOrder;
    }

    public boolean minHeapOrder() {
        return minHeapOrder(1);
    }


    public boolean less(T v, T u) {
        return v.compareTo(u) < 0;
    }
}
