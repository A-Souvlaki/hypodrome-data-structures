package dataStructures;

import dataStructures.Exception.QueueException;

public interface IQueue<E>{
	/**
	 * Check if the data structure is empty
	 * @return True if is empty false if is not
	 */
	public boolean isEmpty();
	/**
	 * </pre> The queue has been created
	 * @param Element the element to be added
	 * @throws QueueException If the item could not be added
	 */
	public void enqueue(E Element)throws QueueException;
	/**
	 * Removes the front element in the queue
	 * @throws QueueException If the queue is empty
	 */
	public E dequeue() throws QueueException;
	/**
	 * </Post>If the queue is not empty the item at the front of the list is returned, and the queue is left unchanged. Throws QueueException if is empty
	 * @return
	 */
	public E front() throws QueueException;
	/**
	 * This method allows me to know whether the queue is full or not
	 * @return True if is full false if is not full
	 */
	
	/**
	 * This method allows to obtain the size from a queue
	 * @return A value representing the size of the queue
	 */
	public int getSize();
	/**
	 * 
	 * @return
	 */
	
	public boolean isFull();
	/**
	 * 
	 */
	public void resize();
	
	/**
	 * 
	 */
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public E getIndexOf(int i);
		
}
