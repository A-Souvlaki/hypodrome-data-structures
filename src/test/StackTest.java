package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.IQueue;
import dataStructures.IStack;
import dataStructures.Exception.ListException;
import dataStructures.Exception.QueueException;
import dataStructures.GenericsClasses.Queue;
import dataStructures.GenericsClasses.Stack;

class StackTest {
	
	private IStack<Integer> numbers;

	void setupScenary1() {
		numbers = new Stack<>(Integer.class, 100);
	}

	void setupScenary2() {
		numbers = new Stack<>(Integer.class, 1000);
	}
	//________________________________________________________//
	@Test
	void testIsEmpty1() {
		setupScenary1();
		assertTrue(numbers.isEmpty());
	}

	@Test
	void testIsEmpty2() throws ListException {
		setupScenary1();
		numbers.push(9);
		assertFalse(numbers.isEmpty());
	}
	
	@Test
	void testIsEmpty3() throws ListException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.push(i);
		}
		assertFalse(numbers.isEmpty());
	}
	//________________________________________________________//
	
	@Test
	void testPop1() throws ListException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.push(i);
		}
		
		assertEquals(99, numbers.pop());
	}
	
	@Test
	void testPop2() throws ListException {
		setupScenary2();
		for (int i = 0; i < 1000; i++) {
			numbers.push(i);
		}
		
		assertEquals(999, numbers.pop());
		
	}
	
	//________________________________________________________//
	
	@Test
	void testPush1() throws ListException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.push(i);
		}
		assertTrue(numbers.isFull());
	}
	
	@Test
	void testPush2() throws ListException {
		setupScenary2();
		for (int i = 0; i < 1000; i++) {
			numbers.push(i);
		}
		assertTrue(numbers.isFull());
	}
	
	//________________________________________________________//
	
	@Test
	void testTop1() throws ListException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.push(i);
		}
		
		assertEquals(99, numbers.top());
	}
	
	@Test
	void testTop2() throws ListException {
		setupScenary2();
		for (int i = 999; i >= 0; i--) {
			numbers.push(i);
		}


		assertEquals(0, numbers.top());
	}
	
	//________________________________________________________//
	
	@Test
	void testIsFull1() throws ListException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.push(i);
		}
		
		assertTrue(numbers.isFull());
	}
	
	@Test
	void testIsFull2() throws ListException {
		setupScenary2();
		for (int i = 0; i < 1000; i++) {
			numbers.push(i);
		}
		
		assertTrue(numbers.isFull());
	}
	
	@Test
	void testIsFull3() throws QueueException {
		setupScenary1();
		
		
		assertFalse(numbers.isFull());
	}
	
	@Test
	void testIsFull4() throws QueueException {
		setupScenary2();
	
		
		assertFalse(numbers.isFull());
	}
	
}
