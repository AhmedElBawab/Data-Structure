package eg.edu.alexu.csd.datastructure.calculator.cs08;

import java.util.Scanner;

/**
 * @author ahmed
 *
 */

public class Main {

	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int x = input.nextInt();
		int y = input.nextInt();

		MyCalculator calObject = new MyCalculator();

		System.out.println(calObject.add(x, y));

		if (calObject.divide(x, y) != 0) {
			System.out.println(calObject.divide(x, y));
		}
	}
}
