package model;

import java.util.ArrayList;

import dataStructures.IQueue;
import dataStructures.IStack;
import dataStructures.Exception.ListException;
import dataStructures.Exception.QueueException;
import dataStructures.GenericsClasses.Queue;
import dataStructures.GenericsClasses.Stack;

public class Career {
	
	private IQueue<Rider> riders;
	
	private IStack<Rider> rematch;
	
	public Career() {
		riders = new Queue<>(Rider.class,10);
		rematch = new Stack<>(Rider.class,10);
	}
	/**
	 * This method register a rider within the given parameters
	 * @param name A String that indicates the rider's name
	 * @param track An integer that represent the track 
	 * @param horseMan A String that represent 
	 * @throws QueueException 
	 */
	public void registerRiders(String name,String track,String horseName) throws QueueException{
		Rider toAdd = new Rider(name,track,horseName);
		riders.enqueue(toAdd);
	}
	/**
	 * This method allows to verify if there are the enough numbers of riders to begin the career
	 * @return A true value that indicates if there are the enough numbers of riders to begin the career
	 */
	public boolean openBets() {
		if(riders.getSize()==7||riders.getSize()<=10) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This method allows to get a winner from the list of riders
	 * @return A rider that wins the career
	 */
	public Rider getWinner() {
		int ramdon;
		if(riders.getSize() == 7) {
			ramdon = (int)Math.floor(Math.random()*(6-0+1)+0);
		}else if(riders.getSize() == 8) {
			ramdon = (int)Math.floor(Math.random()*(7-0+1)+0);
		}else if(riders.getSize() == 9) {
			ramdon = (int)Math.floor(Math.random()*(8-0+1)+0);
		}else {
			ramdon = (int)Math.floor(Math.random()*(9-0+1)+0);
		}
		
		if (!riders.getIndexOf(ramdon).getWinner()) {
			riders.getIndexOf(ramdon).setWinner(true);
		}else {
			getWinner();
		}
		return riders.getIndexOf(ramdon);
	}
	
	/**
	 * This method allows to re do the career with a the rider in inverse order
	 * @throws ListException
	 * @throws QueueException
	 */
	public void rematch() throws ListException, QueueException {
		int indexQueue = riders.getSize();
		for (int i = 0; i < indexQueue; i++) {
			rematch.push(riders.getIndexOf(i));
		}
		
		riders = new Queue<>(Rider.class,10);
		
		for (int i = 0; i < indexQueue; i++) {
			Rider  a = (Rider)rematch.pop();
			riders.enqueue(a);
		}
	}
	
	/**
	 * This method allows to clean a queue to initialize a new career
	 * @throws QueueException 
	 * 
	 */
	public void reNew() throws QueueException {
		int indexQueue = riders.getSize();
		for (int i = 0; i < indexQueue; i++) {
			riders.dequeue();
		}
	}
	
	//Methods for the UI
	public ArrayList<Rider> ridersToShow(){
		int indexQueue = riders.getSize();
		ArrayList<Rider> r = new ArrayList<Rider>();
		for (int i = 0; i < indexQueue; i++) {
			r.add(riders.getIndexOf(i));
		}
		return r;
	}
	
	public int numbersToList() {
		return riders.getSize();
	}
	
	public Rider getARider(int n) {
		return riders.getIndexOf(n);
	}
		
}
	
	
	


