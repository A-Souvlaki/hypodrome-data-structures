package dataStructures.GenericsClasses;

import java.lang.reflect.Array;

import dataStructures.IQueue;
import dataStructures.Exception.QueueException;

public class Queue<E> implements IQueue<E> {

	private E[] theQueue;

	private int size, rear, front, currentSize;

	@SuppressWarnings("unchecked")
	public Queue(Class<E> cls, int size) {
		this.size = size;
		theQueue = (E[]) Array.newInstance(cls, size);
		rear = -1;
		front = 0;
		currentSize = 0;

	}

	@Override
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void enqueue(E Element) throws QueueException {
		if (!isFull()) {
			rear++;
			if (rear >= theQueue.length && currentSize != theQueue.length) {
				rear = 0;
			}
			theQueue[rear] = Element;
			currentSize++;
		}else {
			throw new QueueException("Queue is full");
		}

	}

	@Override
	public E dequeue() throws QueueException {
		E toReturn = null;
		if (isEmpty()) {
			throw new QueueException("Queue empty");
		} else {
			front++;
			if (front > theQueue.length - 1) {
				toReturn = theQueue[front - 1];
				theQueue[front - 1] = null;
				front = 0;
			} else {
				toReturn = theQueue[front - 1];
				theQueue[front - 1] = null;
			}
			currentSize--;
		}

		return toReturn;
	}

	@Override
	public E front() throws QueueException {
		if(!isEmpty()) {
			return theQueue[front];
		}else {
			throw new QueueException("Queue is empty");
		}
	}
	
	@Override
	public int getSize() {
		return currentSize;
	}

	@Override
	public boolean isFull() {
		boolean full = false;
		if (currentSize==size) {
			full = true;
		}
		return full;

	}

	@Override
	public void resize() {

	}

	@Override
	public E getIndexOf(int i) {
		return theQueue[i];
	}

}
