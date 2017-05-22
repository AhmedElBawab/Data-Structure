package eg.edu.alexu.csd.datastructure.linkedList.cs24_08;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class UserInterFaceChoices {

	Scanner input = new Scanner(System.in);
	IPolynomialSolver l = new App();

	public void welcome() {
		System.out.println("WELCOME TO THE POLYNOMIAL CALCULATOR FX-1");
		System.out.println("-----------------------------------------");

	}

	public void PrintMenue() {
		System.out.println("Please choose an action");
		System.out.println("-----------------------");

		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");

		System.out.println("====================================================================");
	}

	public void choice1() {

		System.out.println("Insert the variable name : A, B or C");
		char poly = input.next().charAt(0);
		if (poly == 'A' || poly == 'B' || poly == 'C') {

			System.out.println("Insert the polynomial terms in the form :");
			System.out.println("(coeff1 , exponent1 ), (coeff2 , exponent2 ), ..");
			System.out.println("-------Enter '-100' to end the pylonomial---------");
			int[][] arr = new int[10][2];
			int flag = 1;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 2; j++) {
					arr[i][j] = input.nextInt();
					if (arr[i][j] == -100) {
						flag = 0;
						break;
					}
				}
				if (flag == 0) {
					break;
				}
			}
			if (poly == 'A') {
				System.out.println("Polynomial A is set");
			}
			if (poly == 'B') {
				System.out.println("Polynomial B is set");
			}
			if (poly == 'C') {
				System.out.println("Polynomial C is set");
			}

			l.setPolynomial(poly, arr);
			System.out.println("====================================================================");
		} else {
			System.out.println("Variable Not Avalible");
		}
	}

	public void choice2() {
		System.out.println("Insert the variable name : A, B, C or R");
		char poly = input.next().charAt(0);
		System.out.println(l.print(poly));
		System.out.println("====================================================================");

	}

	public void choice3() {
		System.out.println("Insert the variable name : A, B or C");
		char poly1 = input.next().charAt(0);
		System.out.println("Insert the variable name : A, B or C");
		char poly2 = input.next().charAt(0);
		int[][] K = l.add(poly1, poly2);
		for (int i = 0; i < K.length; i++) {
			if (K[i][0] != 0) {
				System.out.print("(");
				for (int j = 0; j < 2; j++) {

					System.out.print(K[i][j]);
					if (j == 0) {
						System.out.print(",");
					}
				}
				System.out.print(")");
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println("====================================================================");
	}

	public void choice4() {
		System.out.println("Insert the variable name : A, B or C");
		char poly1 = input.next().charAt(0);
		System.out.println("Insert the variable name : A, B or C");
		char poly2 = input.next().charAt(0);
		int[][] K = l.subtract(poly1, poly2);
		for (int i = 0; i < K.length; i++) {
			if (K[i][0] != 0) {
				System.out.print("(");
				for (int j = 0; j < 2; j++) {

					System.out.print(K[i][j]);
					if (j == 0) {
						System.out.print(",");
					}
				}
				System.out.print(")");
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println("====================================================================");
	}

	public void choice5() {
		System.out.println("Insert the variable name : A, B or C");
		char poly1 = input.next().charAt(0);
		System.out.println("Insert the variable name : A, B or C");
		char poly2 = input.next().charAt(0);
		int[][] K = l.multiply(poly1, poly2);
		for (int i = 0; i < K.length; i++) {
			if (K[i][0] != 0) {
				System.out.print("(");
				for (int j = 0; j < 2; j++) {

					System.out.print(K[i][j]);
					if (j == 0) {
						System.out.print(",");
					}
				}
				System.out.print(")");
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println("====================================================================");
	}

	public void choice6() {
		System.out.println("Insert the variable name : A, B, C or R");
		char poly = input.next().charAt(0);
		System.out.println("Insert the float point");
		float value = input.nextFloat();
		System.out.println(l.evaluatePolynomial(poly, value));
		System.out.println("====================================================================");
	}

	public void choice7() {
		System.out.println("Insert the variable name : A, B or C");
		char poly = input.next().charAt(0);
		l.clearPolynomial(poly);
		System.out.println("====================================================================");
	}

}
