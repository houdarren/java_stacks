/**
* JUnit tests for the ArrayStack class.
* @author Darren Hou
* 
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
 

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class ArrayStackTest {
	private static ArrayStack stack;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	 
	@Before
	public void setUpBefore() throws Exception {
		//System.setOut(new PrintStream(outContent));
		stack = new ArrayStack();
		stack.push(0);
		stack.push(1.91212);
		stack.push(2.31);
	}
	
	@Test(expected = EmptyStackException.class) 
	public void testPopException() {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		stack.pop();
	}
	
	@Test(expected = EmptyStackException.class) 
	public void testPeekException() {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		stack.peek();
	}
	
	@Test
	public void testIsEmpty1() {
		assertFalse(stack.isEmpty()); 
	}
	
	@Test
	public void testIsEmpty2() {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		assertTrue(stack.isEmpty()); 
	}
	
	@Test
	public void testPop() {
		assertEquals(2.31, stack.pop(), .00000001); 
		assertEquals(1.91212, stack.pop(), .00000001); 
		assertEquals(0.0, stack.pop(), .00000001); 
	}
	
	@Test
	public void testPush() {
		stack.push(3.45);
		stack.push(4);
		assertEquals(4, stack.pop(), .00000001);
		assertEquals(3.45, stack.pop(), .00000001);
		assertEquals(2.31, stack.pop(), .00000001);
	}
	
	@Test
	public void testPeek() {
		assertEquals(2.31, stack.peek(), .00000001);
		assertEquals(2.31, stack.pop(), .00000001);
		assertEquals(1.91212, stack.peek(), .00000001);
		assertEquals(1.91212, stack.pop(), .00000001);
	}
	
	@Test
	public void testOverflow1() {
		for (int i = 3; i < 100; i++) {
			stack.push(i);
			assertEquals(i, stack.peek(), .00000001);
		}
	}
	
	@Test
	public void testOverflow2() {
		while (!stack.isEmpty()) {
			stack.pop();
		}
		for (int i = 0; i < 100; i++) {
			stack.push(i);
		}
		for (int i = 99; i >= 0; i--) {
			//System.out.println(stack.peek());
			assertEquals(i, stack.pop(), .00000001);
		}
	}
}
