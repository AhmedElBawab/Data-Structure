package eg.edu.alexu.csd.datastructure.queue.cs08;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class QueueLinkedListBased implements IQueue, ILinkedBased {

	SingleListNode head = null;
	SingleListNode tail = null;
	int counter = 0;

	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if (item == null) {
			throw null;
		}
		SingleListNode newNode = new SingleListNode();
		newNode.value = item;
		if (counter == 0) {
			this.head = newNode;
			this.tail = newNode;
			this.counter++;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
			this.counter++;
		}

	}

	public Object dequeue() {
		// TODO Auto-generated method stub
		if (counter == 0) {
			throw null;
		}
		Object temp = this.head.value;
		this.head = this.head.next;
		counter--;
		return temp;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.counter == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.counter;
	}

}
