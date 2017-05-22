package eg.edu.alexu.csd.datastructure.linkedList.cs24_08;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class App implements IPolynomialSolver {

	RuntimeException e = new RuntimeException();

	private DoubleLinkedList R = new DoubleLinkedList();

	private DoubleLinkedList A = new DoubleLinkedList();

	private DoubleLinkedList B = new DoubleLinkedList();

	private DoubleLinkedList C = new DoubleLinkedList();

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// TODO Auto-generated method stub

		int noOfNodes = terms[0][1];

		if (poly == 'A') {

			// set nodes without last node
			for (int index = 0; index < noOfNodes; index++) {
				A.add(index, 0);

			}
			doubleListNode i = A.head;
			while (i.next != null) {
				i = i.next;
			}
			int counter = 0;
			A.add(terms[counter][0]);// set last node
			i = i.next;
			counter++;

			// set all nodes
			for (int index = noOfNodes - 1; index >= 0; index--) {
				if (index == terms[counter][1]) {
					i.pre.value = terms[counter][0];
					counter++;
					i = i.pre;
				} else {
					i.pre.value = 0;
					i = i.pre;

				}
			}

		} else if (poly == 'B') {

			// set nodes without last node
			for (int index = 0; index < noOfNodes; index++) {
				B.add(index, 0);

			}
			doubleListNode i = B.head;
			while (i.next != null) {
				i = i.next;
			}
			int counter = 0;
			B.add(terms[counter][0]);// set last node
			i = i.next;
			counter++;
			// set all nodes
			for (int index = noOfNodes - 1; index >= 0; index--) {
				if (index == terms[counter][1]) {
					i.pre.value = terms[counter][0];
					counter++;
					i = i.pre;
				} else {
					i.pre.value = 0;
					i = i.pre;

				}
			}
		} else if (poly == 'C') {

			// set nodes without last node
			for (int index = 0; index < noOfNodes; index++) {
				C.add(index, 0);

			}
			doubleListNode i = C.head;
			while (i.next != null) {
				i = i.next;
			}
			int counter = 0;
			C.add(terms[counter][0]);// set last node
			i = i.next;
			counter++;
			// set all nodes
			for (int index = noOfNodes - 1; index >= 0; index--) {
				if (index == terms[counter][1]) {
					i.pre.value = terms[counter][0];
					counter++;
					i = i.pre;
				} else {
					i.pre.value = 0;
					i = i.pre;

				}
			}
		} else {
			throw e;
		}
	}

	@Override
	public String print(char poly) {
		// TODO Auto-generated method stub

		StringBuilder string = new StringBuilder();
		doubleListNode tailA = new doubleListNode();
		doubleListNode tailB = new doubleListNode();
		doubleListNode tailC = new doubleListNode();
		doubleListNode tailR = new doubleListNode();
		tailA = A.tail;
		tailB = B.tail;
		tailC = C.tail;
		tailR = R.tail;
		int c = 0;

		if (poly == 'A') {
			while (tailA.pre != null) {
				c++;
				tailA = tailA.pre;
			}
			tailA = A.tail;
			if (A.head == null) {
				return null;

			} else {

				while (tailA != null) {
					if ((Integer) tailA.value == 0) {
						if (tailA != A.tail && tailA != A.head) {
							if ((Integer) tailA.pre.value > 0) {
								string.append('+');
							}

						}
					} else {
						if (c != 0) {
							if ((Integer) tailA.value != 1) {
								string.append((Integer) tailA.value);
							}
							string.append('x');
							if (c > 1) {
								string.append('^');
								string.append(c);
							}
							if ((Integer) tailA.pre.value > 0) {
								string.append('+');
							}

						} else {
							string.append((Integer) tailA.value);
						}
					}

					c--;
					tailA = tailA.pre;
				}
			}
		} else if (poly == 'B') {
			while (tailB.pre != null) {
				c++;
				tailB = tailB.pre;
			}
			tailB = B.tail;
			if (B.head == null) {
				return null;

			} else {
				while (tailB != null) {
					if ((Integer) tailB.value == 0) {
						if (tailB != B.tail && tailB != B.head) {
							if ((Integer) tailB.pre.value > 0) {
								string.append('+');
							}
						}
					} else {
						if (c != 0) {
							if ((Integer) tailB.value != 1) {
								string.append((Integer) tailB.value);
							}
							string.append('x');
							if (c > 1) {
								string.append('^');
								string.append(c);
							}
							if ((Integer) tailB.pre.value > 0) {
								string.append('+');
							}
						} else {
							string.append((Integer) tailB.value);
						}

					}
					c--;
					tailB = tailB.pre;
				}
			}
		} else if (poly == 'C') {
			while (tailC.pre != null) {
				c++;
				tailC = tailC.pre;
			}
			tailC = C.tail;
			if (C.head == null) {
				return null;

			} else {
				while (tailC != null) {
					if ((Integer) tailC.value == 0) {
						if (tailC != C.tail && tailC != C.head) {
							if ((Integer) tailC.pre.value > 0) {
								string.append('+');
							}
						}
					} else {
						if (c != 0) {
							if ((Integer) tailC.value != 1) {
								string.append((Integer) tailC.value);
							}
							string.append('x');
							if (c > 1) {
								string.append('^');
								string.append(c);
							}
							if ((Integer) tailC.pre.value > 0) {
								string.append('+');
							}
						} else {
							string.append((Integer) tailC.value);
						}

					}
					c--;
					tailC = tailC.pre;
				}
			}
		} else if (poly == 'R') {
			while (tailR.pre != null) {
				c++;
				tailR = tailR.pre;
			}
			tailR = R.tail;
			if (R.head == null) {
				return null;

			} else {
				while (tailR != null) {
					if ((Integer) tailR.value == 0) {
						if (tailR != R.tail && tailR != R.head) {
							if ((Integer) tailR.pre.value > 0) {
								string.append('+');
							}
						}
					} else {
						if (c != 0) {
							if ((Integer) tailR.value != 1) {
								string.append((Integer) tailR.value);
							}
							string.append('x');
							if (c > 1) {
								string.append('^');
								string.append(c);
							}
							if ((Integer) tailR.pre.value > 0) {
								string.append('+');
							}
						} else {
							string.append((Integer) tailR.value);
						}

					}
					c--;
					tailR = tailR.pre;
				}
			}
		} else {
			throw e;
		}

		return String.valueOf(string);

	}

	@Override
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub
		if (poly == 'A') {
			if (A.head.next == null) {
				A.head = null;
			} else {
				A.head = null;

				A.tail = null;
			}

		}

		else if (poly == 'B') {
			if (B.head.next == null) {
				B.head = null;
			} else {
				B.head = null;

				B.tail = null;
			}

		}

		else if (poly == 'C') {
			if (C.head.next == null) {
				C.head = null;
			} else {
				C.head = null;

				C.tail = null;
			}

		}

		else if (poly == 'R') {
			if (R.head.next == null) {
				R.head = null;
			} else {
				R.head = null;

				R.tail = null;
			}

		} else {
			throw e;
		}
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub

		doubleListNode headA = new doubleListNode();
		doubleListNode headB = new doubleListNode();
		doubleListNode headC = new doubleListNode();
		doubleListNode headR = new doubleListNode();
		headA = A.head;
		headB = B.head;
		headC = C.head;
		headR = R.head;
		float c = 0;
		double z;
		float sum = 0;
		if (poly == 'A') {
			if (A.head != null) {
				while (headA != null) {
					z = ((Integer) headA.value * (Math.pow(value, c)));
					sum = sum + (float) z;

					c++;
					headA = headA.next;
				}

			} else {

				return 0;
			}
		} else if (poly == 'B') {
			if (B.head != null) {
				while (headB != null) {
					z = ((Integer) headB.value * (Math.pow(value, c)));
					sum = sum + (float) z;
					c++;
					headB = headB.next;
				}

			} else {
				return 0;
			}
		} else if (poly == 'C') {
			if (C.head != null) {
				while (headC != null) {
					z = ((Integer) headC.value * (Math.pow(value, c)));
					sum = sum + (float) z;
					c++;
					headC = headC.next;
				}
			} else {
				return 0;
			}
		} else if (poly == 'R') {
			if (R.head != null) {
				while (headR != null) {
					z = ((Integer) headR.value * (Math.pow(value, c)));
					sum = sum + (float) z;
					c++;
					headR = headR.next;
				}
			} else {
				return 0;
			}
		} else {
			throw e;
		}

		return sum;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		if (R.head != null) {
			clearPolynomial('R');
		}

		doubleListNode headA = new doubleListNode();
		doubleListNode headB = new doubleListNode();
		doubleListNode headC = new doubleListNode();

		headA = A.head;
		headB = B.head;
		headC = C.head;

		int cA = 0, cB = 0, cC = 0, cR = 0;
		if ((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')) {
			while (headA.next != null) {
				cA++;
				headA = headA.next;
			}

			while (headB.next != null) {
				cB++;
				headB = headB.next;
			}
			if (cA == cB) {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) A.get(i) + (Integer) B.get(i)));
				}
			} else if (cA > cB) {
				for (int i = 0; i <= cB; i++) {
					R.add(i, (Object) ((Integer) A.get(i) + (Integer) B.get(i)));
				}
				for (int j = cB + 1; j <= cA; j++) {
					R.add(A.get(j));
				}
			} else {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) A.get(i) + (Integer) B.get(i)));
				}
				for (int j = cA + 1; j <= cB; j++) {
					R.add(B.get(j));
				}
			}

		}

		else if ((poly1 == 'A' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'A')) {
			while (headA.next != null) {
				cA++;
				headA = headA.next;
			}
			while (headC.next != null) {
				cC++;
				headC = headC.next;
			}
			if (cA == cC) {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) A.get(i) + (Integer) C.get(i)));
				}
			} else if (cA > cC) {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) A.get(i) + (Integer) C.get(i)));
				}
				for (int j = cC + 1; j <= cA; j++) {
					R.add(A.get(j));
				}
			} else {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) A.get(i) + (Integer) C.get(i)));
				}
				for (int j = cA + 1; j <= cC; j++) {
					R.add(C.get(j));
				}
			}

		}

		else if ((poly1 == 'C' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'C')) {
			while (headC.next != null) {
				cC++;
				headC = headC.next;
			}
			while (headB.next != null) {
				cB++;
				headB = headB.next;
			}
			if (cC == cB) {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) C.get(i) + (Integer) B.get(i)));
				}
			} else if (cC > cB) {
				for (int i = 0; i <= cB; i++) {
					R.add(i, (Object) ((Integer) C.get(i) + (Integer) B.get(i)));
				}
				for (int j = cB + 1; j <= cC; j++) {
					R.add(C.get(j));
				}
			} else {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) C.get(i) + (Integer) B.get(i)));
				}
				for (int j = cC + 1; j <= cB; j++) {
					R.add(B.get(j));
				}
			}

		} else {
			throw e;
		}

		doubleListNode headR = new doubleListNode();
		headR = R.head;
		while (headR.next != null) {

			cR++;
			headR = headR.next;
		}

		int[][] r = new int[cR + 1][2];
		doubleListNode tailR = new doubleListNode();
		tailR = R.tail;
		int f = cR;

		for (int i = 0; i <= cR; i++) {

			r[i][0] = (Integer) tailR.value;
			r[i][1] = f;
			f--;
			tailR = tailR.pre;
		}

		return r;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub

		if (R.head != null) {
			clearPolynomial('R');
		}
		doubleListNode headA = new doubleListNode();
		doubleListNode headB = new doubleListNode();
		doubleListNode headC = new doubleListNode();

		headA = A.head;
		headB = B.head;
		headC = C.head;

		int cA = 0, cB = 0, cC = 0, cR = 0;
		if ((poly1 == 'A' && poly2 == 'B')) {
			while (headA.next != null) {
				cA++;
				headA = headA.next;
			}
			while (headB.next != null) {
				cB++;
				headB = headB.next;
			}
			if (cA == cB) {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) A.get(i) - (Integer) B.get(i)));
				}
			} else if (cA > cB) {
				for (int i = 0; i <= cB; i++) {
					R.add(i, (Object) ((Integer) A.get(i) - (Integer) B.get(i)));
				}
				for (int j = cB + 1; j <= cA; j++) {
					R.add(A.get(j));
				}
			} else {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) A.get(i) - (Integer) B.get(i)));
				}
				for (int j = cA + 1; j <= cB; j++) {
					R.add((Object) (0 - (Integer) B.get(j)));
				}
			}

		}

		else if ((poly1 == 'B' && poly2 == 'A')) {
			while (headA.next != null) {
				cA++;
				headA = headA.next;
			}
			while (headB.next != null) {
				cB++;
				headB = headB.next;
			}
			if (cA == cB) {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) B.get(i) - (Integer) A.get(i)));
				}
			} else if (cA > cB) {
				for (int i = 0; i <= cB; i++) {
					R.add(i, (Object) ((Integer) B.get(i) - (Integer) A.get(i)));
				}
				for (int j = cB + 1; j <= cA; j++) {
					R.add((Object) (0 - (Integer) A.get(j)));
				}
			} else {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) B.get(i) - (Integer) A.get(i)));
				}
				for (int j = cA + 1; j <= cB; j++) {
					R.add(B.get(j));
				}
			}

		}

		else if ((poly1 == 'A' && poly2 == 'C')) {
			while (headA.next != null) {
				cA++;
				headA = headA.next;
			}
			while (headC.next != null) {
				cC++;
				headC = headC.next;
			}
			if (cA == cC) {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) A.get(i) - (Integer) C.get(i)));
				}
			} else if (cA > cC) {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) A.get(i) - (Integer) C.get(i)));
				}
				for (int j = cC + 1; j <= cA; j++) {
					R.add(A.get(j));
				}
			} else {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) A.get(i) - (Integer) C.get(i)));
				}
				for (int j = cA + 1; j <= cC; j++) {
					R.add((Object) (0 - (Integer) C.get(j)));
				}
			}

		}

		else if ((poly1 == 'C' && poly2 == 'A')) {
			while (headA.next != null) {
				cA++;
				headA = headA.next;
			}
			while (headC.next != null) {
				cC++;
				headC = headC.next;
			}
			if (cA == cC) {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) C.get(i) - (Integer) A.get(i)));
				}
			} else if (cA > cC) {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) C.get(i) - (Integer) A.get(i)));
				}
				for (int j = cC + 1; j <= cA; j++) {
					R.add((Object) (0 - (Integer) A.get(j)));
				}
			} else {
				for (int i = 0; i <= cA; i++) {
					R.add(i, (Object) ((Integer) C.get(i) - (Integer) A.get(i)));
				}
				for (int j = cA + 1; j <= cC; j++) {
					R.add(C.get(j));
				}
			}

		}

		else if ((poly1 == 'C' && poly2 == 'B')) {
			while (headC.next != null) {
				cC++;
				headC = headC.next;
			}
			while (headB.next != null) {
				cB++;
				headB = headB.next;
			}
			if (cC == cB) {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) C.get(i) - (Integer) B.get(i)));
				}
			} else if (cC > cB) {
				for (int i = 0; i <= cB; i++) {
					R.add(i, (Object) ((Integer) C.get(i) - (Integer) B.get(i)));
				}
				for (int j = cB + 1; j <= cC; j++) {
					R.add(C.get(j));
				}
			} else {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) C.get(i) - (Integer) B.get(i)));
				}
				for (int j = cC + 1; j <= cB; j++) {
					R.add((Object) (0 - (Integer) B.get(j)));
				}
			}

		}

		else if ((poly1 == 'B' && poly2 == 'C')) {
			while (headC.next != null) {
				cC++;
				headC = headC.next;
			}
			while (headB.next != null) {
				cB++;
				headB = headB.next;
			}
			if (cC == cB) {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) B.get(i) - (Integer) C.get(i)));
				}
			} else if (cC > cB) {
				for (int i = 0; i <= cB; i++) {
					R.add(i, (Object) ((Integer) B.get(i) - (Integer) C.get(i)));
				}
				for (int j = cB + 1; j <= cC; j++) {
					R.add((Object) (0 - (Integer) C.get(j)));
				}
			} else {
				for (int i = 0; i <= cC; i++) {
					R.add(i, (Object) ((Integer) B.get(i) - (Integer) C.get(i)));
				}
				for (int j = cC + 1; j <= cB; j++) {
					R.add(B.get(j));
				}
			}

		} else {
			throw e;
		}

		doubleListNode headR = new doubleListNode();
		headR = R.head;
		while (headR.next != null) {

			cR++;
			headR = headR.next;
		}
		int[][] r = new int[cR + 1][2];
		doubleListNode tailR = new doubleListNode();
		tailR = R.tail;
		int f = cR;
		for (int i = 0; i <= cR; i++) {
			r[i][0] = (Integer) tailR.value;
			r[i][1] = f;
			f--;
			tailR = tailR.pre;
		}
		return r;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		if (R.head != null) {
			clearPolynomial('R');
		}
		doubleListNode tailA = new doubleListNode();
		doubleListNode tailB = new doubleListNode();
		doubleListNode tailC = new doubleListNode();

		tailA = A.tail;
		tailB = B.tail;
		tailC = C.tail;
		int cA = 0, cB = 0, cC = 0, cr = 0;

		if ((poly1 == 'A' && poly2 == 'B') || (poly1 == 'B' && poly2 == 'A')) {
			while (tailA.pre != null) {
				cA++;
				tailA = tailA.pre;
			}
			while (tailB.pre != null) {
				cB++;
				tailB = tailB.pre;
			}
			tailA = A.tail;
			tailB = B.tail;
			cr = cA + cB;
			for (int i = 0; i <= cr; i++) {
				R.add(i, 0);
			}

			Object x;
			for (int i = cA; i >= 0; i--) {
				for (int j = cB; j >= 0; j--) {
					x = R.get(i + j);
					x = (Integer) x + ((Integer) A.get(i) * (Integer) B.get(j));
					R.set(i + j, x);
				}
			}

		}

		else if ((poly1 == 'A' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'A')) {
			while (tailA.pre != null) {
				cA++;
				tailA = tailA.pre;
			}
			while (tailC.pre != null) {
				cC++;
				tailC = tailC.pre;
			}
			tailA = A.tail;
			tailC = C.tail;
			cr = cA + cC;
			for (int i = 0; i <= cr; i++) {
				R.add(i, 0);
			}

			Object x;
			for (int i = cA; i >= 0; i--) {
				for (int j = cC; j >= 0; j--) {
					x = R.get(i + j);
					x = (Integer) x + ((Integer) A.get(i) * (Integer) C.get(j));
					R.set(i + j, x);
				}
			}

		}

		else if ((poly1 == 'B' && poly2 == 'C') || (poly1 == 'C' && poly2 == 'B')) {
			while (tailC.pre != null) {
				cC++;
				tailC = tailC.pre;
			}
			while (tailB.pre != null) {
				cB++;
				tailB = tailB.pre;
			}
			tailC = C.tail;
			tailB = B.tail;
			cr = cC + cB;
			for (int i = 0; i <= cr; i++) {
				R.add(i, 0);
			}

			Object x;
			for (int i = cC; i >= 0; i--) {
				for (int j = cB; j >= 0; j--) {
					x = R.get(i + j);
					x = (Integer) x + ((Integer) C.get(i) * (Integer) B.get(j));
					R.set(i + j, x);
				}
			}

		} else {
			throw e;
		}
		int cR = 0;
		doubleListNode headR = new doubleListNode();
		headR = R.head;
		while (headR.next != null) {

			cR++;
			headR = headR.next;
		}

		int[][] r = new int[cR + 1][2];
		doubleListNode tailR = new doubleListNode();
		tailR = R.tail;
		int f = cR;

		for (int i = 0; i <= cR; i++) {

			r[i][0] = (Integer) tailR.value;
			r[i][1] = f;
			f--;
			tailR = tailR.pre;
		}

		return r;
	}

}
