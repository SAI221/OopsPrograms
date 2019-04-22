package com.bridgelabz.util;

import java.util.Iterator;
import java.util.Scanner;

public class CustomLinkedList<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;

	public CustomLinkedList() {
		head = null;
	}

	static Scanner s = new Scanner(System.in);

	public static int userInt() {
		return s.nextInt();
	}

	public static double userDouble() {
		return s.nextDouble();
	}

	public static boolean userBoolean() {
		return s.nextBoolean();
	}

	public static String userString() {
		return s.next();
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(E share) {
		Node<E> nd = new Node<>();
		nd.setValue(share);
		System.out.println(share);
		if (isEmpty()) {
			head = nd;
			tail = nd;
		} else {
			tail.setNextRef(nd); // tail.setNext(nd);
			tail = nd;
		}
	}

	public E get(int index) {
		Node<E> temp = head;
		int i = 0;
		while (i != index) {
			temp = temp.getNextRef();
			i++;
		}
		return temp.getValue();
	}

	public int search(String data) {
		Node<E> temp = head;
		int i = 0;
		while (!temp.getValue().equals(data)) {
			temp = temp.getNextRef();
			i++;
			// while (temp.getNextRef() != null) {
			/*
			* if (temp.getValue().equals(data)) { return i; } temp = temp.getNextRef();
			* i++;
			*/
		}
		return i;
	}

	public int index(E data) {

		/*
		* Node<T> curr = head; int count = 0; while (curr != null) { if
		* (curr.getValue().equals(data)) { //curr.getNextRef(); return count; } else
		* count++; curr = curr.getNextRef(); } //assert (false);
		* 
		* return count;
		*/

		Node<E> node = head;
		System.out.println("NODE=" + node.getValue().toString());

		for (int i = 0; i < size(); i++) {
			System.out.println("*qqqqq" + node.getValue());
			if (node.getValue().equals(data)) {
				System.out.println("found");
				return i;
			}
			node = node.nextRef;
			// System.out.println("refference node="+node.toString());
		}

		return -1;
	}

	/**
	* Function to remove the element of the specified index
	* 
	* @param index the index of an element which is needed to be deleted
	* @return
	*/
	public void remove(int index) {
		if (isEmpty())
			return;
		Node<E> temp = head;
		if (index == 0) {
			head = temp.getNextRef();
			return;
		}
		for (int i = 0; temp != null && i < index - 1; i++) {
			temp = temp.getNextRef();
		}
		if (temp == null || temp.getNextRef() == null)
			return;
		Node<E> next = temp.getNextRef().getNextRef();

		temp.setNextRef(next);
	}

	/*
	* public void remove(E element) { Node<E> temp = head; if
	* (temp.getValue().equals(element)) { head = temp.getNextRef(); } while (temp
	* != null) { Node<E> nextRef = temp.getNextRef(); if (nextRef != null &&
	* nextRef.getValue().equals(element)) { temp.setNextRef(nextRef.getNextRef());
	* } temp = temp.getNextRef(); } }
	*/
	public void remove(E data) {
		// Store head node
		System.out.println("Object to be Deleted" + data);
		Node<E> temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.getValue().equals(data)) {
			head = temp.getNextRef(); // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (temp != null && !data.equals(temp.getValue())) {
			prev = temp;
			temp = temp.getNextRef();
		}

		// If key was not present in linked list
		if (temp == null)
			return;

		// Unlink the node from linked list
		prev.setNextRef(temp.getNextRef());
		if (prev.getNextRef()==null) {
			tail=prev;
		}
	}

	/**
	* Function that returns the size of the linked list
	* 
	* @return
	*/
	public int size() {
		Node<E> tnode = head;
		int len = 0;
		while (tnode != null) {
			len++;
			tnode = tnode.getNextRef();
		}
		return len;
	}

	public String[] convArray(String[] array) {
		Node<E> tnode = head;
		int i = 0;
		while (tnode != null) {
			array[i] = String.valueOf(tnode.getValue());
			tnode = tnode.getNextRef();
			i++;
		}
		return array;
	}

	public static int[] convertIntArray(String[] arr) {
		int[] arrInt = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrInt[i] = Integer.valueOf(arr[i]);
		}
		return arrInt;
	}

	public static int[] sort(int[] intArray) {
		int temp;
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray.length - 1; j++) {
				if (intArray[j] > intArray[j + 1]) {
					temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
				}
			}
		}
		return intArray;
	}

	public void printList() {
		Node<E> tnode = head;
		while (tnode != null) {
			System.out.print(tnode.getValue() + " ");
			tnode = tnode.getNextRef();
		}
	}

	@Override
	public String toString() {
		String data = "";
		Node<E> tnode = head;
		while (tnode != null) {
			E value = tnode.getValue();
			data += value.toString();
			tnode = tnode.getNextRef();
		}
		return data;
	}

	@Override
	public Iterator<E> iterator() {
		return new CustomIterator<>(this);
	}

	public class CustomIterator<E> implements Iterator<E> {

		Node<E> current = null;

		public CustomIterator(CustomLinkedList<E> list) {
			current = list.head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E value = current.getValue();
			current = current.getNextRef();
			return value;
		}

	}
}