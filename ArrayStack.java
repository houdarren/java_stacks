/**
 * @author Darren Hou
 * 
 * Implements the DStack class with an array.
 */

import java.util.EmptyStackException;

public class ArrayStack implements DStack {
	
	private double[] stack; // array to store the elements of the stack
	
	private int numberOfElements; // current number of elements in the stack
	
	/**
	 * Constructs an ArrayStack object, initializes number of elements
	 */
	public ArrayStack() {
		numberOfElements = 0;
		stack = new double[10];
	}
	
	/**
	 * @return		True if the stack is empty
	 */
	public boolean isEmpty() {
		return numberOfElements == 0;
	}
	
	/**
	 * Pushes the passed double d to the top of the stack
	 * 
	 * @param d		the element to be pushed onto the stack
	 */
	public void push(double d) {
		numberOfElements++; // increment number of elements
		
		// check if number of elements has reached the maximum number allowed
		if (numberOfElements == stack.length) {
			resize(stack.length * 2); // double size of array
		}
		
		// replace old with new value at appropriate place in array
		stack[numberOfElements - 1] = d;
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
		
		// check if number of elements is 1/4 or less that of maximum number allowed
		if ((numberOfElements - 1) * 4 <= stack.length) {
			resize((stack.length + 1) / 2); // halve size of array, rounding up
		}
		numberOfElements--; // decrement number of elements
		return stack[numberOfElements]; // return element previously at top of stack
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
		return stack[numberOfElements - 1]; // return element at top of stack
	}
	
	
	/**
	 * Resizes the current array into one with the length of the passed int
	 * 
	 * @param size		the size of the new array
	 */
	private void resize(int size) {
		double[] temp = new double[size];
		
		// copy appropriate number of elements from old to new array
		for (int i = 0; i < numberOfElements; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}
}
