package stackleetcode;

import java.util.Stack;

public class MinStack {
//    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//    Implement the MinStack class:
//
//    MinStack() initializes the stack object.
//    void push(int val) pushes the element val onto the stack.
//    void pop() removes the element on the top of the stack.
//    int top() gets the top element of the stack.
//    int getMin() retrieves the minimum element in the stack.
//    You must implement a solution with O(1) time complexity for each function.

    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();

        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
//        minStack1.push(4);
//        minStack1.push(-9);
//        minStack1.push(-6);
        System.out.println(minStack1.getMin());
        minStack1.pop();
        System.out.println(minStack1.top());
        System.out.println(minStack1.getMin());
        minStack1.pop();
        minStack1.pop();

    }

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || minStack.peek() > value) {
            minStack.push(value);
        } else {
            // To maintain length
            minStack.push(minStack.peek());
        }
        System.out.println("stack = " + stack);
        System.out.println("minStack = " + minStack);
    }
    public void pop() {
        stack.pop();
        minStack.pop();
        System.out.println("stack = " + stack);
        System.out.println("minStack = " + minStack);
    }
    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
