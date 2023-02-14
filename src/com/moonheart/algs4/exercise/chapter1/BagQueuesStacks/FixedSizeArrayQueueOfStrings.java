package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

import java.util.Scanner;

public class FixedSizeArrayQueueOfStrings {
    private static Scanner scanner;
    private int head, tail, size;
    private String[] items;

    public FixedSizeArrayQueueOfStrings(int capacity) {
        this.items = new String[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public void enqueue(String item) {
        if (!isFull()) {
            items[tail] = item;
            tail++;
            if (tail == items.length) {
                tail = 0;
            }
            size++;
        } else throw new RuntimeException("Queue overflow");
    }

    public String dequeue() {
        String item;
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        } else {
            item = items[head];
            items[head] = null;
            head++;
            if (head == items.length) head = 0;
        }
        size--;
        return item;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        FixedSizeArrayQueueOfStrings qs = new FixedSizeArrayQueueOfStrings(4);
        qs.enqueue("I");
        qs.enqueue("am");
        qs.enqueue("a");
        qs.enqueue("student");
        System.out.print(qs.dequeue() + " ");
        qs.enqueue("cool");
        System.out.print(qs.dequeue() + " " + "\n");
        System.out.println("remain in stack is:");
        while (!qs.isEmpty()) {
            System.out.print(qs.dequeue() + " ");
        }
    }

}
