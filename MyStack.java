package Stack;

import java.util.NoSuchElementException;

public class MyStack<T> {

    private Object[] stack;
    private int top;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        stack = new Object[DEFAULT_CAPACITY];
        top = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = -1;
        size = 0;
    }

    public void push(T value) {
        if (size >= stack.length) {
            increaseCapacity();
        }
        top++;
        stack[top] = value;
        size++;
    }

    public T pop() {
        checkNotEmpty();
        T element = (T) stack[top];
        top--;
        size--;
        return element;
    }

    public T peek() {
        checkNotEmpty();
        return (T) stack[top];
    }

    private void checkNotEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is empty");
        }
    }

    private void increaseCapacity() {
        int newCapacity = stack.length * 2;
        Object[] newStack = new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }
}