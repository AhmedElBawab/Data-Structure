package eg.edu.alexu.csd.datastructure.maze.cs08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {

	public int n;
	public int m;
	public String[] step;
	public char[][] map;

	public void readfromfile(String path) throws IOException {

		int bufferSize = 8 * 1024;

		BufferedReader bufferedReader = new BufferedReader(new FileReader(path), bufferSize);

		String line = bufferedReader.readLine();

		this.n = line.charAt(0) - 48;
		this.m = line.charAt(2) - 48;

		line = bufferedReader.readLine();

		int counter = 0;
		step = new String[n];
		this.map = new char[100][100];

		while (line != null) {
			step[counter] = line;
			this.map[counter] = line.toCharArray();
			counter++;
			line = bufferedReader.readLine();
		}
	}

	void readFromFile(File maze) {
		// set map Array
		Scanner s = null;
		try {
			s = new Scanner(maze);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}

		this.n = s.nextInt();
		this.m = s.nextInt();
		this.map = new char[n][m];

		for (int i = 0; i < n; i++) {
			final String temp = s.next();
			this.map[i] = temp.toCharArray();
		}
	}

}
