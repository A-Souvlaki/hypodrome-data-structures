package dataStructures.GenericsClasses;

import dataStructures.ILinkedList;
import dataStructures.Exception.QueueException;

public class QueueLinkedList<E> {
	private ILinkedList<E> TheQueue;

	private Node<E> front, rear;
	private int size;

	public QueueLinkedList() {

		front = null;
		rear = null;
		size = 0;
	}

	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		return false;
	}

	public void enqueue(E Element) throws QueueException {
		Node<E> newNode = new Node<E>(Element);
		if (isEmpty()) {
			front = newNode;
		} else {
			rear.next = newNode;
		}
		rear = newNode;
		size++;
	}

	public Node<E> dequeue() throws QueueException {

		return removeFirst();

	}

	public Node<E> front() throws QueueException {

		return front;
	}

	public Node<E> removeFirst() {
		Node<E> temp = front;
		if (front.next == null) {
			rear = null;
		}
		front = front.next;
		size--;
		return temp;
	}

}
