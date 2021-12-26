package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.IQueue;
import dataStructures.Exception.QueueException;
import dataStructures.GenericsClasses.Queue;

class QueueTest {

	private IQueue<Integer> numbers;

	void setupScenary1() {
		numbers = new Queue<>(Integer.class, 100);
	}

	void setupScenary2() {
		numbers = new Queue<>(Integer.class, 1000);
	}
	
	//________________________________________________________//

	@Test
	void testIsEmpty1() {
		setupScenary1();
		assertTrue(numbers.isEmpty());
	}

	@Test
	void testIsEmpty2() throws QueueException {
		setupScenary1();
		numbers.enqueue(9);
		assertFalse(numbers.isEmpty());
	}
	
	@Test
	void testIsEmpty3() throws QueueException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.enqueue(i);
		}
		assertFalse(numbers.isEmpty());
	}
	
	//________________________________________________________//
	
	@Test
	void testEnqueue1() throws QueueException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.enqueue(i);
		}
		assertEquals(100, numbers.getSize());
	}
	
	@Test
	void testEnqueue2() throws QueueException {
		setupScenary2();
		for (int i = 0; i < 1000; i++) {
			numbers.enqueue(i);
		}
		assertEquals(1000, numbers.getSize());
	}
	
	//________________________________________________________//
	
	@Test
	void testDequeue1() throws QueueException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.enqueue(i);
		}
		
		numbers.dequeue();
		assertEquals(99, numbers.getSize());
	}
	
	@Test
	void testDequeue2() throws QueueException {
		setupScenary2();
		for (int i = 0; i < 1000; i++) {
			numbers.enqueue(i);
		}
		
		numbers.dequeue();
		assertEquals(999, numbers.getSize());
	}
	
	//________________________________________________________//
	
	@Test
	void testFront1() throws QueueException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.enqueue(i);
		}
		
		assertEquals(0, numbers.front());
	}
	
	@Test
	void testFront2() throws QueueException {
		setupScenary2();
		for (int i = 999; i >= 0; i--) {
			numbers.enqueue(i);
		}


		assertEquals(999, numbers.front());
	}
	
	//________________________________________________________//
	
	@Test
	void testGetSize1() throws QueueException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.enqueue(i);
		}
		
		assertEquals(100, numbers.getSize());
	}
	
	@Test
	void testGetSize2() throws QueueException {
		setupScenary2();
		for (int i = 0; i < 1000; i++) {
			numbers.enqueue(i);
		}
		
		assertEquals(1000, numbers.getSize());
	}
	
	//________________________________________________________//
	
	@Test
	void testIsFull1() throws QueueException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.enqueue(i);
		}
		
		assertTrue(numbers.isFull());
	}
	
	@Test
	void testIsFull2() throws QueueException {
		setupScenary2();
		for (int i = 0; i < 1000; i++) {
			numbers.enqueue(i);
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
	
	//________________________________________________________//
	@Test
	void testGetIndexOf1() throws QueueException {
		setupScenary1();
		for (int i = 0; i < 100; i++) {
			numbers.enqueue(i);
		}
		assertEquals(numbers.getIndexOf(25), 25);
	}
	
	@Test
	void testGetIndexOf2() throws QueueException {
		setupScenary2();
		for (int i = 0; i < 1000; i++) {
			numbers.enqueue(i);
		}
		
		assertEquals(numbers.getIndexOf(250), 250);
	}
}
