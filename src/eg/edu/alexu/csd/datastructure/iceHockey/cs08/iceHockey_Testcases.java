package eg.edu.alexu.csd.datastructure.iceHockey.cs08;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**
 * @author ahmed
 *
 */
public class iceHockey_Testcases {

	IceHockey test = new IceHockey();

	@Test
	public void testFindPlayer1() {
		IPlayersFinder IceHockey = (IPlayersFinder) test;
		String[] photo = { "33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" };
		Point[] ExpectedPonits = new Point[3];
		ExpectedPonits[0] = new Point(4, 5);
		ExpectedPonits[1] = new Point(13, 9);
		ExpectedPonits[2] = new Point(14, 2);
		Point[] OutputPoints = test.findPlayers(photo, 3, 16);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}

	@Test
	public void testFindPlayer2() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = { "44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44", "44C4D4U444", "4V4Y4KB4M4",
				"G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444" };
		Point[] ExpectedPonits = new Point[6];
		ExpectedPonits[0] = new Point(3, 8);
		ExpectedPonits[1] = new Point(4, 16);
		ExpectedPonits[2] = new Point(5, 4);
		ExpectedPonits[3] = new Point(16, 3);
		ExpectedPonits[4] = new Point(16, 17);
		ExpectedPonits[5] = new Point(17, 9);
		Point[] OutputPoints = test.findPlayers(photo, 4, 16);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}

	@Test
	public void testFindPlayer3() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = { "8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8EO", "LUQ888A8TH8OIH8",
				"888QJ88R8SG88TY", "88ZQV88B88OUZ8O", "FQ88WF8Q8GG88B8", "8S888HGSB8FT8S8", "8MX88D88888T8K8",
				"8S8A88MGVDG8XK8", "M88S8B8I8M88J8N", "8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8" };
		Point[] ExpectedPonits = new Point[19];
		ExpectedPonits[0] = new Point(1, 17);
		ExpectedPonits[1] = new Point(3, 3);
		ExpectedPonits[2] = new Point(3, 10);
		ExpectedPonits[3] = new Point(3, 25);
		ExpectedPonits[4] = new Point(5, 21);
		ExpectedPonits[5] = new Point(8, 17);
		ExpectedPonits[6] = new Point(9, 2);
		ExpectedPonits[7] = new Point(10, 9);
		ExpectedPonits[8] = new Point(12, 23);
		ExpectedPonits[9] = new Point(17, 16);
		ExpectedPonits[10] = new Point(18, 3);
		ExpectedPonits[11] = new Point(18, 11);
		ExpectedPonits[12] = new Point(18, 28);
		ExpectedPonits[13] = new Point(22, 20);
		ExpectedPonits[14] = new Point(23, 26);
		ExpectedPonits[15] = new Point(24, 15);
		ExpectedPonits[16] = new Point(27, 2);
		ExpectedPonits[17] = new Point(28, 26);
		ExpectedPonits[18] = new Point(29, 16);
		Point[] OutputPoints = test.findPlayers(photo, 8, 9);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}

	@Test
	public void testFindPlayer4() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = { "11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
		Point[] ExpectedPonits = new Point[2];
		ExpectedPonits[0] = new Point(5, 5);
		ExpectedPonits[1] = new Point(5, 5);
		Point[] OutputPoints = test.findPlayers(photo, 1, 3);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}

	@Test
	public void testFindPlayer5() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = { "1111111", "11AAA11", "11A1A11", "11A1A11", "11A1A11", "11AAA11", "1111111" };
		Point[] ExpectedPonits = new Point[2];
		ExpectedPonits[0] = new Point(7, 7);
		ExpectedPonits[1] = new Point(7, 7);
		Point[] OutputPoints = test.findPlayers(photo, 1, 4);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}

	@Test
	public void testFindPlayer6() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = { "6AAAAAA", "A6AAAAA", "AA6AAAA", "AAA6AAA", "AAAA6AA", "AAAAA6A", "AAAAAA6" };
		Point[] ExpectedPonits = new Point[0];
		Point[] OutputPoints = test.findPlayers(photo, 6, 2);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}

	@Test
	public void testFindPlayer7() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = { "6AAAAAA", "A6AAAAA", "AA6AAAA", "AAA6AAA", "AAAA6AA", "AAAAA6A", "AAAAAA6" };
		Point[] ExpectedPonits = new Point[0];
		Point[] OutputPoints = test.findPlayers(photo, 7, 5);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}

	@Test
	public void testFindPlayer8() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = { "5555", "5555", "5555", };
		Point[] ExpectedPonits = new Point[1];
		ExpectedPonits[0] = new Point(4, 3);
		Point[] OutputPoints = test.findPlayers(photo, 5, 2);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}

	@Test
	public void testFindPlayer9() {
		IPlayersFinder iceHockey = (IPlayersFinder) test;
		String[] photo = { "5555", "5555", "5555", };
		Point[] ExpectedPonits = new Point[0];
		Point[] OutputPoints = test.findPlayers(photo, 5, 50);
		for (int i = 0; i < 6; i++)
			Assert.assertEquals(ExpectedPonits[i], OutputPoints[i]);
	}
}