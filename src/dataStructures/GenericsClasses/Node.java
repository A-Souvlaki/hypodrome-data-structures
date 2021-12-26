package dataStructures.GenericsClasses;

public class Node<T> {
    Node<T> next;
    public T item;
    private int index;

    public Node(T item) {
        this.item = item;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public T getValue() {
        return this.item;
    }
    
    public int getIndex() {
		return index;
	}
    public void setIndex(int index) {
		this.index = index;
	}
    public String toString() {
		return "Data ItTm = " + item;
	}

}