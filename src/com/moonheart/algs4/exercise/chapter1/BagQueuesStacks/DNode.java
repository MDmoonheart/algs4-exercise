package com.moonheart.algs4.exercise.chapter1.BagQueuesStacks;

public class DNode<Item> {
    Item item;
    DNode<Item> next;
    DNode<Item> prev;

    public DNode() {
        this.next = null;
        this.prev = null;
        this.item = null;
    }

    public DNode(Item item) {
        this.item = item;
        this.next = null;
        this.prev = null;
    }

    public DNode(Item item, DNode<Item> next) {
        this.item = item;
        this.next = next;
        this.prev = null;
    }

    public DNode(Item item, DNode<Item> next, DNode<Item> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

}

