package fundamentals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println(intStack.peek());

        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("Allan");
        stringQueue.add("Esther");
        stringQueue.add("Mike");

        System.out.println(stringQueue.peek());
    }
}
