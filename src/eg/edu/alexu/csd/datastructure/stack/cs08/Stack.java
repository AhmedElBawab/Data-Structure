package eg.edu.alexu.csd.datastructure.stack.cs08;

import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack {

	ListNode head = null;
	int counter = 0;
	RuntimeException e = new RuntimeException();

	@Override
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

	@Override
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

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			throw null;
		}
		return this.head.value;
	}

	@Override
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

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.counter == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if (this.isEmpty()) {
			return 0;
		}
		return counter;
	}

}