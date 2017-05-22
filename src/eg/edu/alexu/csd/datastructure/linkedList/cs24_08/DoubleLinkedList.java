package eg.edu.alexu.csd.datastructure.linkedList.cs24_08;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DoubleLinkedList implements ILinkedList {
	doubleListNode head = null;
	doubleListNode tail = null;

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

		if ((index < 0) || (index > size()) || (element == null)) {
			throw null;
		}

		doubleListNode newNode = new doubleListNode();
		doubleListNode i = this.head;
		newNode.value = element;
		if (index == 0) {

			newNode.next = this.head;
			this.head = newNode;
		} else {
			for (int j = 0; j < index - 1; j++) {
				i = i.next;
			}
			if (i.next == null) {
				if (tail != null) {
					tail.next = newNode;
					newNode.pre = tail;
					tail = newNode;
				} else {
					this.head.next = newNode;
					newNode.pre = this.head;
					tail = newNode;
				}
			} else {
				newNode.next = i.next;
				i.next.pre = newNode;
				newNode.pre = i;
				i.next = newNode;
			}
		}
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		if (element == null) {
			throw null;
		}

		doubleListNode newNode = new doubleListNode();

		newNode.value = element;

		if (head == null) {
			head = newNode;
		} else {
			if (tail == null) {
				head.next = newNode;
				newNode.pre = head;

				tail = newNode;
			} else {

				tail.next = newNode;

				newNode.pre = tail;
				tail = newNode;
			}
		}

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size() - 1 || isEmpty()) {
			return null;
		}

		doubleListNode i = this.head;

		for (int j = 0; j < index; j++) {
			i = i.next;
		}

		return i.value;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size() - 1 || element == null) {
			throw null;
		}
		doubleListNode i = this.head;

		for (int j = 0; j < index; j++) {
			i = i.next;
		}

		i.value = element;

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

		if (head.next == null) {
			head = null;
		} else {
			head = null;

			tail = null;
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

		if (index < 0 || index > size() - 1) {
			throw null;
		}
		doubleListNode i = this.head;
		if (index == 0) {
			this.head = this.head.next;
		} else {

			for (int j = 0; j < index - 1; j++) {
				i = i.next;
			}
			if (i.next.next == null) {
				i.next = null;
				tail = i;
			} else {
				doubleListNode l = i.next.next;
				i.next = l;
				l.pre = i;
			}
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub

		if (isEmpty()) {
			return 0;
		} else {
			int counter = 1;
			doubleListNode i = this.head;
			while (i.next != null) {
				i = i.next;
				counter++;
			}
			return counter;
		}
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {

		if (fromIndex > toIndex || fromIndex < 0 || toIndex >= size() || isEmpty()) {
			throw null;
		} else {
			// TODO Auto-generated method stub
			ILinkedList d = new DoubleLinkedList();
			doubleListNode i = this.head;
			doubleListNode k = this.head;

			for (int j = 0; j < fromIndex; j++) {
				i = i.next;
			}
			for (int j = 0; j < toIndex; j++) {
				k = k.next;
			}
			i.pre = null;
			this.head = i;
			k.next = null;
			this.tail = k;
			/*
			 * doubleListNode l = new doubleListNode();
			 * 
			 * l = this.head; for (int j = 0; j < toIndex; j++) {
			 * d.add(l.value); l = l.next; }
			 */
			return d;
		}
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub

		if (isEmpty()) {
			return false;
		} else {
			doubleListNode i = head;

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
