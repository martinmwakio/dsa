/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <Item>
 * @author KELVIN WARUI
 */
public class ArrayStack<Item> implements Iterable<Item> {

    private Item[] a;//stack items
    int N;//stack size

    public ArrayStack(int size) {
        a = (Item[]) new Object[size];
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        System.arraycopy(a, 0, temp, 0, a.length);
        a = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public Item pop() {
        //remove item from top of stack
        Item item = a[--N];
        //avoid loitering
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            if (i == 0) {
                throw new NoSuchElementException("Stack is empty");
            }
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(1);
        for (int i = 0; i < 7; i++) {
            stack.push("to");
            System.out.println("Stack size is " + stack.size());
        }
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("Popping top item...");
        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.size() + " items left in stack");
    }
}
