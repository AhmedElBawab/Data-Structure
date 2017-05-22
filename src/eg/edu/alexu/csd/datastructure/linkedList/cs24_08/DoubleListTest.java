package eg.edu.alexu.csd.datastructure.linkedList.cs24_08;

import static org.junit.Assert.*;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import junit.framework.Assert;

public class DoubleListTest {

	DoubleLinkedList testobject = new DoubleLinkedList();

	@Test
	public void test1() {
		int[] a = { 4, 5, 8, 7, 9 };
		for (int i = 0; i < 5; i++) {
			testobject.add(i, a[i]);
		}

		int expectedoutput = 7;
		int actualoutput = (int) testobject.get(3);
		assertEquals(expectedoutput, actualoutput);
	}

	@Test
	public void test2() {
		int[] a = { 4, 5, 8, 7, 9 };
		for (int i = 0; i < 5; i++) {
			testobject.add(i, a[i]);
		}
		testobject.add(3, 11);
		int expectedoutput = 11;
		int actualoutput = (int) testobject.get(3);
		assertEquals(expectedoutput, actualoutput);

	}

	@Test
	public void test3() {
		int[] a = { 4, 5, 8, 7, 9 };
		for (int i = 0; i < 5; i++) {
			testobject.add(i, a[i]);
		}
		testobject.set(1, 2);
		int expectedoutput = 2;
		int actualoutput = (int) testobject.get(1);
		assertEquals(expectedoutput, actualoutput);

	}

	@Test
	public void test4() {
		int[] a = { 4, 5, 8, 7, 9 };
		for (int i = 0; i < 5; i++) {
			testobject.add(i, a[i]);
		}
		testobject.sublist(1, 3);

		int expectedoutput = 3;
		int actualoutput = (int) testobject.size();
		assertEquals(expectedoutput, actualoutput);

		int expectedoutput1 = 5;
		int actualoutput1 = (int) testobject.get(0);
		assertEquals(expectedoutput1, actualoutput1);

		int expectedoutput2 = 8;
		int actualoutput2 = (int) testobject.get(1);
		assertEquals(expectedoutput2, actualoutput2);

		int expectedoutput3 = 7;
		int actualoutput3 = (int) testobject.get(2);
		assertEquals(expectedoutput3, actualoutput3);

	}

	@Test
	public void test5() {
		int[] a = { 4, 5, 8, 7, 9 };
		for (int i = 0; i < 5; i++) {
			testobject.add(i, a[i]);
		}
		testobject.remove(2);

		int expectedoutput = 4;
		int actualoutput = (int) testobject.size();
		assertEquals(expectedoutput, actualoutput);

		int expectedoutput1 = 8;
		int actualoutput1 = (int) testobject.get(2);
		assertNotEquals(expectedoutput1, actualoutput1);

	}

	@Test
	public void test6() {
		int[] a = { 4, 5, 8, 7, 9 };
		for (int i = 0; i < 5; i++) {
			testobject.add(i, a[i]);
		}
		boolean expectedoutput = true;
		boolean actualoutput = (boolean) testobject.contains(8);
		assertEquals(expectedoutput, actualoutput);

		boolean expectedoutput1 = false;
		boolean actualoutput1 = (boolean) testobject.contains(2);
		assertEquals(expectedoutput1, actualoutput1);
	}

	@Test
	public void test7() {
		int[] a = { 4, 5, 8, 7, 9 };
		for (int i = 0; i < 5; i++) {
			testobject.add(i, a[i]);
		}
		testobject.clear();

		boolean expectedoutput = true;
		boolean actualoutput = (boolean) testobject.isEmpty();
		assertEquals(expectedoutput, actualoutput);
	}

}
