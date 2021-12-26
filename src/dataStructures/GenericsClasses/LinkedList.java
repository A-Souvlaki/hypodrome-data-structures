package dataStructures.GenericsClasses;

import dataStructures.Exception.ListException;
import dataStructures.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {

	private Node<T> head;

	private int size;

	@Override
	public void addElement(T Element) throws ListException {
		Node<T> newNode = new Node<T>(Element);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> last = head;

			while (last.next != null) {
				last = last.next;
			}
			last.setNext(newNode);

		}
		size++;
		head.setIndex(size);
	}

	/**
	 * 
	 */
	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 */

	public void delete() {
		Node<T> temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = head.next;
		head = head.next;
		size--;

	}

	@Override
	public Node<T> deleteLast() {

		Node<T> toReturn = null;
		Node<T> temp = head;
		Node<T> actual = null;
		if (!isEmpty()) {
			if (size >= 3) {
				while (temp.next != null) {
					temp = temp.next;
					actual = temp.next;
					if (actual.getNext() == null) {
						toReturn = (Node<T>)actual;
						temp.setNext(null);
						size--;
					}

				}
			}
		} else if (size == 1) {
			toReturn = head;
			head = null;
		} else {
			toReturn = head.next;
			head.setNext(null);
		}

		return toReturn;

	}

	@Override
	public Node<T> deleteWithoutRemove() {
		Node<T> toReturn = null;
		Node<T> temp = head;
		if (!isEmpty()) {
			if (size >= 3) {
				while (temp.next != null) {
					temp = temp.next;
					if (temp.getNext() == null) {
						toReturn = temp;

					}
				}

			}
		} else if (size == 1) {
			toReturn = head;

		} else {
			toReturn = head.next;

		}

		return toReturn;
	}

	/**
	 * 
	 */
	@Override
	public void deleteAll() {
		while (size > 0) {
			Node<T> temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = head.next;
			head = head.next;
			size--;
		}

	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getElement(int n) throws NullPointerException {
		T TR = null;
		while (n <= size || head.getNext() != null) {
			if (head.getIndex() == n) {
				head = (Node<T>) TR;
			} else {
				head.getNext();
			}
		}
		return TR;
	}

	/**
	 * This method is used to access to the head of the linked list
	 * 
	 * @return The head of the linked list
	 * @throws NullPointerException When the head is null
	 */
	public Node<T> getFirst() throws NullPointerException {
		return head;
	}

	@Override
	public int size() {
		return size;
	}

}
