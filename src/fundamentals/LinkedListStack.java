/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals;

import java.util.NoSuchElementException;

/**
 *
 * @author KELVIN WARUI
 * @param <Item>
 */
public class LinkedListStack<Item> {

    private Node first;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        if (!isEmpty()) {
            Node oldFirst = first;
            node.next = oldFirst;
        }
        first = node;
        N++;
    }

    public Node pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Node node = first;
        first = first.next;
        N--;
        return node;
    }

    private class Node {

        Item item;
        Node next;
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        //System.out.println(stack.pop());
        stack.push("to");
        stack.push("be");
        stack.push("or");
        System.out.println("size is " + stack.size());
        System.out.println(stack.pop());
        System.out.println("size is " + stack.size());
    }
}
