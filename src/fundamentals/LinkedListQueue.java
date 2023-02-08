/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author KELVIN WARUI
 * @param <Item>
 */
public class LinkedListQueue<Item> implements Iterable<Item> {

    private Node first;//link to least recently added node
    private Node last;//link to most recently added node
    private int N;//total items in the queue

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Node oldFirst = first;
        /*if the item to be removed is the only one in the queue*/
        if (size() == 1) {
            first = last = null;
        } else {
            first = oldFirst.next;
        }
        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    private class Node {

        Item item;
        Node next;
    }

    public static void main(String[] args) {
        LinkedListQueue<String> stack = new LinkedListQueue<>();
        //System.out.println(stack.pop());
        stack.enqueue("to");
        stack.enqueue("be");
        stack.enqueue("or");
        System.out.println("size is " + stack.size());
        System.out.println("Removing: " + stack.dequeue());
        System.out.println("Removing: " + stack.dequeue());
        System.out.println("Removing: " + stack.dequeue());
        System.out.println("Removing: " + stack.dequeue());
        System.out.println("size is " + stack.size());
    }
}
