package eg.edu.alexu.csd.datastructure.maze.cs08;

public class Stack {

	ListNode head = null;
	int counter = 0;
	RuntimeException e = new RuntimeException();

	/*
	 * * Inserts a specified element at the specified position in the list.
	 * 
	 * @param index zero-based index
	 * 
	 * @param element object to insert
	 * 
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#add(int,
	 * java.lang.Object)
	 */

	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size() || element == null) {
			throw e;
		}
		ListNode newNode = new ListNode();
		newNode.value = element;
		ListNode i = this.head;
		if (index == this.size()) {
			newNode.next = this.head;
			this.head = newNode;
			counter++;
		} else {
			for (int counter = 0; counter < this.size() - index - 1; counter++) {
				i = i.next;
			}
			newNode.next = i.next;
			i.next = newNode;
			counter++;
		}
	}

	/*
	 * Removes the element at the top of stack and returns that element.
	 * 
	 * @return top of stack element, or through exception if empty
	 * 
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#pop()
	 */

	public Object pop() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			throw null;
		}
		counter--;
		ListNode newNode = new ListNode();
		newNode.value = this.head.value;
		this.head = this.head.next;
		return newNode.value;
	}

	/*
	 * Get the element at the top of stack without removing it from stack.
	 * 
	 * @return top of stack element, or through exception if empty
	 * 
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#peek()
	 */

	public Object peek() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			throw null;
		}
		return this.head.value;
	}

	/*
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param object to insert
	 * 
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#push(java.lang.Object)
	 */

	public void push(Object element) {
		// TODO Auto-generated method stub
		if (element == null) {
			throw e;
		}
		counter++;
		ListNode newNode = new ListNode();
		newNode.value = element;
		newNode.next = this.head;
		this.head = newNode;
	}

	/*
	 * Tests if this stack is empty
	 * 
	 * @return true if stack empty
	 * 
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#isEmpty()
	 */

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.counter == 0) {
			return true;
		}
		return false;
	}

	/*
	 * Returns the number of elements in the stack.
	 * 
	 * @return number of elements in the stack
	 * 
	 * @see eg.edu.alexu.csd.datastructure.stack.IStack#size()
	 */

	public int size() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			return 0;
		}
		return counter;
	}

}
