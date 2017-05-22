package eg.edu.alexu.csd.datastructure.linkedList.cs24_08;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class singleLinkedList implements ILinkedList {

	SingleListNode head = null;

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size() || element == null) {
			throw null;
		}
		SingleListNode newNode = new SingleListNode();// New node which will be
														// insert in index
		newNode.value = element;// set the value to new node
		SingleListNode i = this.head;// refrence
		// condition index = 0
		if (index == 0) {
			newNode.next = this.head;
			this.head = newNode;
		} else {
			// search for the index
			for (int counter = 0; counter < index - 1; counter++) {
				i = i.next;
			}
			// putting the new node
			newNode.next = i.next;
			i.next = newNode;
		}
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		if (element == null) {
			throw null;
		}
		SingleListNode newNode = new SingleListNode();// new node
		newNode.value = element;// set value to new node
		if (this.isEmpty()) {
			newNode.next = this.head;
			this.head = newNode;
		} else {
			SingleListNode i = this.head;// refrence
			// search for the tail
			while (i.next != null) {
				i = i.next;
			}
			// putting the new node
			i.next = newNode;
			newNode.next = null;
		}
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size() - 1 || isEmpty()) {
			return null;
		}
		SingleListNode i = this.head;// refrence
		int counter = 0;// counter for the index
		for (int counter1 = 0; counter1 < index; counter1++) {
			i = i.next;
		}
		return i.value;
	}

	@Override
	public void set(int index, Object element) {
		if (index < 0 || index > size() - 1 || element == null) {
			throw null;
		}
		// TODO Auto-generated method stub
		SingleListNode newNode = new SingleListNode();// new node
		newNode.value = element;// set value to new node
		SingleListNode i = this.head;// refrence for prev node
		for (int counter = 0; counter < index; counter++) {
			i = i.next;
		}
		i.value = element;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.head = null;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.head == null) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index > size() - 1) {
			throw null;
		}
		// TODO Auto-generated method stub
		SingleListNode i = this.head;// refrence for prev node
		if (index == 0) {
			this.head = this.head.next;
		} else {
			for (int counter = 0; counter < index - 1; counter++) {
				i = i.next;
			}
			SingleListNode j = i.next;// refrence for node
			i.next = j.next;// remove node
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return 0;
		} else {
			int counter = 1;
			SingleListNode i = this.head;
			while (i.next != null) {
				i = i.next;
				counter++;
			}
			return counter;
		}
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex > toIndex || fromIndex < 0 || toIndex > size() || isEmpty()) {
			return null;
		}
		// TODO Auto-generated method stub
		ILinkedList subListObject = new singleLinkedList();
		SingleListNode i = this.head;
		for (int counter = 0; counter < fromIndex; counter++) {
			i = i.next;
		}
		for (int counter = fromIndex; counter < toIndex + 1; counter++) {
			subListObject.add(i.value);
			i = i.next;
		}
		return subListObject;

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if (isEmpty())
			return false;
		else {
			SingleListNode i = this.head;
			while (i != null) {
				if (i.value == o) {
					return true;
				}
				i = i.next;
			}
			return false;
		}
	}

}