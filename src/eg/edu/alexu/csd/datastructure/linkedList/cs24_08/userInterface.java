package eg.edu.alexu.csd.datastructure.linkedList.cs24_08;

import java.util.Scanner;

public class userInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		UserInterFaceChoices help = new UserInterFaceChoices();

		RuntimeException e = new RuntimeException();

		int end = 1;
		int f = 0;
		while (end != -1) {

			if (f == 0) {
				help.welcome();
				f = 1;
			}
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
			} else if (choice == 7) {
				help.choice7();
			} else {
				throw e;
			}

			System.out.println("ENTER '-1' TO END----OR----ENTER ANY VALUE TO CONTINUE");
			System.out.println("------------------------------------------------------");
			end = input.nextInt();
		}
	}

}
