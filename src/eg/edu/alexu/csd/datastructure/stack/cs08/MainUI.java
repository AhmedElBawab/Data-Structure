package eg.edu.alexu.csd.datastructure.stack.cs08;

import java.util.Scanner;

public class MainUI {

	Scanner input = new Scanner(System.in);
	RuntimeException e = new RuntimeException();
	UI help = new UI();

	public void doThis() {

		help.welcome();

		String x = new String();
		x = input.nextLine();
		int end = 1;

		while (end != -1) {
			help.PrintMenue();
			int choice = input.nextInt();
			if (choice == 1) {
				help.choice1();
			} else if (choice == 2) {
				help.choice2();
			} else if (choice == 3) {
				help.choice3();
			} else if (choice == 4) {
				help.choice4();
			} else if (choice == 5) {
				help.choice5();
			} else if (choice == 6) {
				help.choice6();
			} else {
				throw e;
			}

			System.out.println("ENTER '-1' TO END----OR----ENTER ANY VALUE TO CONTINUE");
			System.out.println("------------------------------------------------------");
			end = input.nextInt();
		}
	}
}