package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings {
    private int size, head, tail;
    private String[] items;
    private static final int INIT_CAPACITY = 8;

    public ResizingArrayQueueOfStrings() {
        items = new String[INIT_CAPACITY];
        size = 0;
        head = 0;
        tail = 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(String item) {
        if (isFull()) {
            resize(2 * items.length);
        }
        items[tail] = item;
        size++;
        tail++;
        if (tail == items.length) tail = 0;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        String item = items[head];
        items[head] = null;
        size--;
        head++;
        if (head == items.length) head = 0;
        if (size > 0 && size <= items.length / 4) resize(items.length / 2);
        return item;
    }

    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return items[head];
    }

    public int size() {
        return size;
    }

    private void resize(int maxLength) {
        String[] temp = new String[maxLength];
        for (int i = 0; i < size; i++) {
            temp[i] = items[(head + i) % items.length];
        }
        items = temp;
        head = 0;
        tail = size;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
