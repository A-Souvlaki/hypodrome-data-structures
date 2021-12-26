package dataStructures;

public interface IHashTable<T> {
	/**
	 * This method allows assign a key for a value in the hash table
	 * @param m It represents a code that could be a large number like a id for example
	 * @param n A prime number which allows generate the position for a element in the hash table
	 * @return A key for the element to insert in the hash table
	 */
	int hashFuntion(int n);
	/**
	 * Description:This method allows to create a HashTable with a key assigned to each value or element that would be entered
	 * @param m It represents a code that could be a large number like a id for example
	 * @param n A prime number which allows generate the position for a element in the hash table
	 */
	boolean insertTable(T object,int n);

	/**
	 * Description:This method allows to search an element in the HashTable
	 * @param m It represents a code that could be a large number like a id for example
	 * @param n A prime number which allows generate the position for a element in the hash table	
	 */
	T search(int n);
}
