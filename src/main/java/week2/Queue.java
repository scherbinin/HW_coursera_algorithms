package week2;

import java.util.Stack;

/**
 * Created by scher on 04.08.2019.
 */
/*
Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.
 */
public class Queue<T> {
    Stack<T> stack2 = new Stack<>();
    Stack<T> stack1 = new Stack<>();

    public T pop(){
        int size = size();

        for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
        }

        T value = stack2.pop();

        for (int i = 0; i < size - 1; i++) {
            stack1.push(stack2.pop());
        }

        return value;
    }

    public void push(T value) {
        stack1.push(value);
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    public int size(){
        return stack1.size();
    }
}
