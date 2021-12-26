package dataStructures.GenericsClasses;

import java.lang.reflect.Array;

import dataStructures.IHashTable;

public class HashTable<T> implements IHashTable<T> {

	public final static int TO_KEY = 1000;
	
	private T[] element;

	private int size;
	
	private int k;
	
	@SuppressWarnings("unchecked")
	public HashTable(Class<T> cls, int size) {
		this.size = size;
		this.k = 0;
		element = (T[]) Array.newInstance(cls, size);
	}

	@Override
	public int hashFuntion(int n) {
		return (int)Math.floor(TO_KEY*(n*((Math.sqrt(5)-1)/2)%1));
	}

	@Override
	public boolean insertTable(T object, int n) {
		boolean i = false;
		int j = hashFuntion(n);
		do {
			if (element[j] == null) {
				element[j] = object;
				i = true;
				k++;
			} else {
				j++;
				k++;
			}
		} while (j < size && !i);
		return i;
	}

	@Override
	public T search(int n) {
		int j = hashFuntion(n);
		while (j < size ) {
			if (element[j] == null) {
				return null;
			} else if (element[j] != null) {
				return element[j];
			} else {
				j++;
			}
		}
		return null;
	}

}
