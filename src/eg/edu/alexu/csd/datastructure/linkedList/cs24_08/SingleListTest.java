package eg.edu.alexu.csd.datastructure.linkedList.cs24_08;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleListTest {

	@Test
	// get tail element
	public void test1() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		char expectedOutput = 'c';
		char actualOutput = (char) tetsObject.get(2);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// get head element
	public void test2() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		char expectedOutput = 'a';
		char actualOutput = (char) tetsObject.get(0);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// get any element
	public void test3() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		char expectedOutput = 'b';
		char actualOutput = (char) tetsObject.get(1);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// add at tail
	public void test4() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		char expectedOutput = 'd';
		char actualOutput = (char) tetsObject.get(3);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// set head element
	public void test5() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		char expectedOutput = 'z';
		char actualOutput = (char) tetsObject.get(0);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// set tail element
	public void test6() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(3, 'z');
		char expectedOutput = 'z';
		char actualOutput = (char) tetsObject.get(3);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// set any element
	public void test7() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(1, 'z');
		char expectedOutput = 'z';
		char actualOutput = (char) tetsObject.get(1);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check clear method
	public void test8() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		tetsObject.clear();
		boolean expectedOutput = true;
		boolean actualOutput = tetsObject.isEmpty();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check not clear
	public void test9() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		boolean expectedOutput = false;
		boolean actualOutput = tetsObject.isEmpty();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// remove head
	public void test10() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		tetsObject.remove(0);
		char expectedOutput = 'b';
		char actualOutput = (char) tetsObject.get(0);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// remove tail
	public void test11() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		tetsObject.remove(3);
		char expectedOutput = 'c';
		char actualOutput = (char) tetsObject.get(2);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// remove any element
	public void test12() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		tetsObject.remove(1);
		char expectedOutput = 'c';
		char actualOutput = (char) tetsObject.get(1);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check empty size
	public void test13() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		tetsObject.remove(2);
		tetsObject.clear();
		int expectedOutput = 0;
		int actualOutput = tetsObject.size();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check size
	public void test14() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		tetsObject.remove(2);
		int expectedOutput = 3;
		int actualOutput = tetsObject.size();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check contain
	public void test15() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		boolean expectedOutput = false;
		boolean actualOutput = tetsObject.contains('y');
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check not contain
	public void test16() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add('d');
		tetsObject.set(0, 'z');
		boolean expectedOutput = true;
		boolean actualOutput = tetsObject.contains('z');
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check sublist size
	public void test17() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add(3, 'd');
		tetsObject.add(4, 'e');
		tetsObject.add(5, 'f');
		tetsObject.sublist(2, 4);
		int expectedOutput = 3;
		int actualOutput = (int) tetsObject.size();
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check sublist elments
	public void test18() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add(3, 'd');
		tetsObject.add(4, 'e');
		tetsObject.add(5, 'f');
		tetsObject.sublist(2, 4);
		char expectedOutput = 'c';
		char actualOutput = (char) tetsObject.get(0);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check sublist set
	public void test19() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add(3, 'd');
		tetsObject.add(4, 'e');
		tetsObject.add(5, 'f');
		tetsObject.sublist(2, 4);
		tetsObject.set(1, 'z');
		char expectedOutput = 'z';
		char actualOutput = (char) tetsObject.get(1);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	// check sublist set
	public void test20() {
		singleLinkedList tetsObject = new singleLinkedList();
		tetsObject.add(0, 'a');
		tetsObject.add(1, 'b');
		tetsObject.add(2, 'c');
		tetsObject.add(3, 'd');
		tetsObject.add(4, 'e');
		tetsObject.add(5, 'f');
		tetsObject.sublist(2, 4);
		tetsObject.remove(1);
		char expectedOutput = 'e';
		char actualOutput = (char) tetsObject.get(1);
		assertEquals(expectedOutput, actualOutput);
	}

}
