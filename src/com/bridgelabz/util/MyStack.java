package com.bridgelabz.util;
public class MyStack<T> {

	private int stackSize;
	private T[] stackArr;
	private int top;

	// Creates stake with given size
	public MyStack(int size) {
		this.stackSize = size;
		this.stackArr = (T[]) new Object[stackSize];
		this.top = -1;
	}

	public MyStack() {
		top = 0;
		stackSize = 0;
	}

	// for pushing
	public void push(T entry) throws Exception {
		if (isStackFull()) {
			throw new Exception("Stack is already full. Can not add element.");
		}
		System.out.println("Adding: " + entry);
		stackArr[++top] = entry;
	}

	// for poping
	public T pop() throws Exception {
		if (isStackEmpty()) {
			throw new Exception("Stack is empty. Can not remove element.");
		}
		T entry = stackArr[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	// for returing last one in stack
	public T peek() {
		return stackArr[top];
	}

	// checking if it is empty or not
	public boolean isStackEmpty() {
		return (top == -1);
	}

	// checking if it is full or not
	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

	public void push1(QueueLinkedList<Integer> entry) throws Exception {
		if (isStackFull()) {
			throw new Exception("Stack is already full. Can not add element.");
		}
		System.out.println("Adding: " + entry);

	}

	public int getSize() {
		// TODO Auto-generated method stub
		return stackSize;
	}
public String toString() {
	String data="";
	if(getSize()!=0) {
		
	}
	return data;
	
}
}