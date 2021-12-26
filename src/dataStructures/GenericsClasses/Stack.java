package dataStructures.GenericsClasses;

import java.lang.reflect.Array;

import dataStructures.ILinkedList;
import dataStructures.IStack;
import dataStructures.Exception.ListException;
import dataStructures.Exception.QueueException;
import model.Rider;

public class Stack<E> implements IStack<E> {

	private int size, rear, front, currentSize;;

	private E[] theStack;

	@SuppressWarnings("unchecked")
	public Stack(Class<E> cls ,int size) {
		this.size = size;
		theStack = (E[])Array.newInstance(cls, size);
		rear = -1;
		front = this.size;
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
	public E pop() {
		E toReturn = null;
		toReturn = theStack[rear];
		theStack[rear] = null;
		rear--;

		return toReturn;
		
	}
	@Override
	public void push(E Element) {
		if (!isFull()) {
			rear++;
			if (rear >= theStack.length && currentSize != theStack.length) {
				rear = 0;
			}
			theStack[rear] = Element;
			currentSize++;
		}
	}

	@Override
	public E top() {
		E toReturn = null;
		toReturn = theStack[rear];

		return toReturn;
	}

	@Override
	public boolean isFull() {
		boolean full = false;
		if (currentSize==size) {
			full = true;
		}
		return full;
	}

}
