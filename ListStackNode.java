/**
 * @author Darren Hou
 * 
 * A node class for the linked list implementation of a stack.
 */

public class ListStackNode {
	
	public double value; // value stored by the node
	
	public ListStackNode next; // pointer to next node
	
	/**
	 * Constructs a ListStackNode; creates a node with the passed double and no next node
	 * 
	 * @param	d		the value for the node
	 */
	public ListStackNode(double d) {
		this(d, null); 
	}
	
	/**
	 * Constructs a ListStackNode; creates a node with the passed double and another following
	 * 
	 * @param	d 		the value for the node
	 * @param	next	a pointer to the following node
	 */
	public ListStackNode(double d, ListStackNode next) {
		value = d;
		this.next = next;
	}
}
