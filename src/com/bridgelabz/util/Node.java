package com.bridgelabz.util;

public class Node<T> implements Comparable<T> {

	public T value;
	public Node<T> nextRef;
	public T key;
	public int size = 0;

	public T getValue() {
		return value;
	}

	public void setValue(T key) {
		this.value = key;
	}

	public Node<T> getNextRef() {
		return nextRef;
	}

	public void setNextRef(Node<T> ref) {
		this.nextRef = ref;
	}

	public Node<T> getSize() {
		return this.getSize();
	}

	public void setSize(Node<T> size) {
		this.nextRef = size;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Node() {

	}

	public Node(T data, Node<T> next) {
		this.value = data;
		this.nextRef = next;
	}
}

/*
 * Deque<T> front; Deque<T> rear;
 * 
 * 
 * // add front
 * 
 * @SuppressWarnings("null") public void addFront(T c) { if (front == null) //
 * if no element in list { front.data = c; rear = front; } else // if element in
 * list { Deque<T> tNode = null; tNode.data = c; tNode.next = front; front.pre =
 * tNode; front = tNode; } size++; }
 * 
 * // add rear public void addRear(T c) { if (front == null) // if no element in
 * list { Deque<T> tNode = new Deque<T>(c); front = tNode; rear = front; } else
 * // if element in list { Deque<T> tNode = new Deque<>(c); rear.next = tNode;
 * tNode.pre = rear; rear = tNode; } size++; }
 * 
 * // remove front public T removeFront() { T val = null; if (front == null) {
 * System.out.println("No elements to delete"); } else { val = front.data; front
 * = front.next; } size--; return val; }
 * 
 * // remove rear public T removeRear() { T val = null; if (front == null) {
 * System.out.println("No element to delete"); } else { val = rear.data; rear =
 * rear.pre; rear.next = null; } size--; return val; }
 * 
 * // to remove public boolean isEmpty() { if (front == null) return true; else
 * return false; }
 * 
 * // return size of dequeue public int size() { return size; }
 * 
 * 
 * }
 */
