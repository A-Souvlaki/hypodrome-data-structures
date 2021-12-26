package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dataStructures.IHashTable;
import dataStructures.GenericsClasses.HashTable;

public class HashTableTest {

	private IHashTable<Integer> numbers;

	void setupScenary1() {

		numbers = new HashTable<Integer>(Integer.class, 100);
	}

	void setupScenary2() {

		numbers = new HashTable<Integer>(Integer.class, 1000);
	}
	
	
	//________________________________________________________//
	
	@Test
	void testInsertTable1() {
		setupScenary1();
		
		
		assertTrue(numbers.insertTable(5, 1052892));
	}
	
	@Test
	void testInsertTable2() {
		setupScenary2();
		numbers.insertTable(235, 1052892);
		
		assertTrue(numbers.insertTable(5, 1052892));
	}
	
	//________________________________________________________//
	
	@Test
	void SearchTable1() {
		setupScenary1();
		numbers.insertTable(5, 1052892);
		numbers.search(1052892);
		
		assertEquals(5, numbers.search(1052892));
	}
	
	@Test
	void SearchTable2() {
		setupScenary2();
		numbers.insertTable(235, 1052892);
		numbers.search(1052892);
		
		assertEquals(235, numbers.search(1052892));
	}

}
