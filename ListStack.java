/**
 * @author Darren Hou
 * 
 * Implements the DStack class with a linked list.
 */

import java.util.EmptyStackException;

public class ListStack implements DStack {
	
	private ListStackNode front; // the front of the stack
	
	/**
	 * Constructs a ListStack object, sets a pointer to the top of the list
	 */
	public ListStack() {
		front = null;
	}
	
	/**
	 * @return		True if the stack is empty
	 */
	public boolean isEmpty() {
		return front == null;
	}
	
	/**
	 * Pushes the passed double d to the top of the stack
	 * 
	 * @param d		the element to be pushed onto the stack
	 */
	public void push(double d) {
		if (isEmpty()) {
			front = new ListStackNode(d);
		} else {
			front = new ListStackNode(d, front); // create new front, storing the pushed value
		}
	}
	
	/**
	 * Returns the topmost element of the stack and removes it
	 * 
	 * @return		the value of the last element pushed onto the stack
	 * @throws		EmptyStackException if the stack is empty
	 */
	public double pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		double value = front.value; 
		front = front.next; // deletes the first item
		return value; // returns the value of the deleted item
	}
	
	/**
	 * Returns the topmost element of the stack (without removal)
	 * 
	 * @return		the value of the last element pushed onto the stack
	 * @throws		EmptyStackException if the stack is empty
	 */
	public double peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return front.value; // returns the value of the front-most item
	}
}
