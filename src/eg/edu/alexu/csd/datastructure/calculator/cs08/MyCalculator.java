package eg.edu.alexu.csd.datastructure.calculator.cs08;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 * @author ahmed
 *
 */

public class MyCalculator implements ICalculator {

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public float divide(int x, int y) {
		// TODO Auto-generated method stub
		if (y == 0) {
			System.out.println("INF");
			return 0;
		} else if (x == 0) {
			System.out.println("0");
			return 0;
		} else {
			float num1 = x;
			float num2 = y;
			return num1 / num2;
		}
	}

}
