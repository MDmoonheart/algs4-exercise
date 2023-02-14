package com.moonheart.algs4.exercise.chapter3.subchapter1;

public class Ex02 {
    
    public class ArrayST<Key, Value> {

        public Key[] keys;
        public Value[] values;
        private int size;

        public ArrayST(int capacity) {
            keys = (Key[]) new Object[capacity];
            values = (Value[]) new Object[capacity];
            size = 0;          
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void put(Key key, Value value) {
            if(key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }

            if(value == null) {
                delete(key);
                return;
            }

            for(int i = 0; i < size; i++) {

            }
        }

        public void delete(Key key) {

        }

    }
}
