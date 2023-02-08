package samples;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList {
    private Node first;
    private Node last;

    public LinkedList() {
    }

    private boolean isEmpty() {
        return first == null;
    }

    private void addFirst(Object item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    private void addLast(Object item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    private void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
    }

    private void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            return;
        }
        var previous = getPrevious(last);
        last = previous;
        previous.next = null;

    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (Objects.equals(current.next, last)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private boolean contains(Object item) {
        return indexOf(item) != -1;
    }

    private int indexOf(Object item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (Objects.equals(current.value, item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    private class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(list.contains(30));
    }
}
