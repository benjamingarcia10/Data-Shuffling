package cs146F19.Garcia.project1;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class gameTest {
	
	LinkedList game;
	
	@BeforeEach
	void setUp() {
		game = new LinkedList();
	}
	
	@Test
	void test1() {
		assertTrue(game.isEmpty());		// Before inserting prisoners, ensure list is empty.
		assertEquals(0, game.size);		// Make sure size is 0.
		game.insert(6);					// Insert 6 prisoners.
		assertFalse(game.isEmpty());	// Ensure list is not empty after insertion.
		assertEquals(6, game.size);		// Ensure size of linked list is as expected based on insertion.
		game.play(2);					// Play game with step 2.
		assertEquals(1, game.winner);	// Check if winner is as expected.
	}
	
	@Test
	void test2() {
		assertTrue(game.isEmpty());		// Before inserting prisoners, ensure list is empty.
		assertEquals(0, game.size);		// Make sure size is 0.
		game.insert(1);					// Insert 1 prisoner.
		assertFalse(game.isEmpty());	// Ensure list is not empty after insertion.
		assertEquals(1, game.size);		// Ensure size of linked list is as expected based on insertion.
		game.play(9);					// Play game with step 9.
		assertEquals(1, game.winner);	// Check if winner is as expected.
	}
	
	@Test
	void test3() {
		assertTrue(game.isEmpty());		// Before inserting prisoners, ensure list is empty.
		assertEquals(0, game.size);		// Make sure size is 0.
		game.insert(7);					// Insert 7 prisoners.
		assertFalse(game.isEmpty());	// Ensure list is not empty after insertion.
		assertEquals(7, game.size);		// Ensure size of linked list is as expected based on insertion.
		game.play(7);					// Play game with step 7.
		assertEquals(4, game.winner);	// Check if winner is as expected.
	}
	
	@Test
	void test4() {
		assertTrue(game.isEmpty());		// Before inserting prisoners, ensure list is empty.
		assertEquals(0, game.size);		// Make sure size is 0.
		game.insert(12);				// Insert 12 prisoners.
		assertFalse(game.isEmpty());	// Ensure list is not empty after insertion.
		assertEquals(12, game.size);	// Ensure size of linked list is as expected based on insertion.
		game.play(8);					// Play game with step 8.
		assertEquals(2, game.winner);	// Check if winner is as expected.
	}
	
	@Test
	void test5() {
		assertTrue(game.isEmpty());		// Before inserting prisoners, ensure list is empty.
		assertEquals(0, game.size);		// Make sure size is 0.
		game.insert(5);					// Insert 5 prisoners.
		assertFalse(game.isEmpty());	// Ensure list is not empty after insertion.
		assertEquals(5, game.size);		// Ensure size of linked list is as expected based on insertion.
		game.play(1);					// Play game with step 1.
		assertEquals(3, game.winner);	// Check if winner is as expected.
	}
}
