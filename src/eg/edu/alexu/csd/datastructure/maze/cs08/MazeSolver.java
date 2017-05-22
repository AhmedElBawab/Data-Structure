package eg.edu.alexu.csd.datastructure.maze.cs08;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;

public class MazeSolver implements IMazeSolver {

	ReadFile l = new ReadFile();
	Stack t = new Stack();
	QueueLinkedListBased q = new QueueLinkedListBased();
	public int n;
	public int m;
	public char[][] map;
	public int x;
	public int y;
	public int[][] way;
	public int counter = 0;
	public int flag = 0;
	public int start = 0;
	public int end = 0;
	public int[][] path;

	@Override
	public int[][] solveBFS(File maze) {
		if (maze == null) {
			throw null;
		}
		// TODO Auto-generated method stub
		this.setValues(maze);
		this.searchStart('S');
		if (this.start == 1) {
			throw null;
		}
		this.searchEnd('E');
		if (this.end == 1) {
			throw null;
		}
		this.setVistedBFS(this.x, this.y);
		this.BFS();
		if (this.flag == 1) {
			path = new int[this.counter][2];
			for (int i = 0; i < this.counter; i++) {
				path[i][0] = this.way[i][0];
				path[i][1] = this.way[i][1];
			}
			return path;
		} else if (this.flag == 0) {
			return null;
		} else {
			throw null;
		}
	}

	@Override
	public int[][] solveDFS(File maze) {
		if (maze == null) {
			return null;
		}
		// TODO Auto-generated method stub
		this.setValues(maze);
		this.searchStart('S');
		if (this.start == 1) {
			throw null;
		}
		this.searchEnd('E');
		if (this.end == 1) {
			throw null;
		}
		this.setVistedDFS(this.x, this.y);
		this.DFS();
		if (this.flag == 1) {
			path = new int[this.counter][2];
			for (int i = 0; i < this.counter; i++) {
				path[i][0] = this.way[i][0];
				path[i][1] = this.way[i][1];
			}
			return path;
		} else if (this.flag == 0) {
			return null;
		} else {
			throw null;
		}
	}

	// -------------------read from file and set values----------------//
	public void setValues(File maze) {
		// l.readfromfile(maze.getAbsolutePath());
		l.readFromFile(maze);
		this.n = l.n;
		this.m = l.m;
		this.map = l.map;
		this.way = new int[n * m][2];
	}

	// ---------------------search for start point---------------------//
	public void searchStart(char s) {
		int l = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (this.map[i][j] == s) {
					this.x = j;
					this.y = i;
					l = 1;
					break;
				}
			}
			if (l == 1) {
				break;
			}
		}
		if (l == 0) {
			this.start = 1;
		}
	}

	// ---------------------search for end point-----------------------//
	public void searchEnd(char e) {
		int l = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (this.map[i][j] == e) {
					l = 1;
					break;
				}
			}
			if (l == 1) {
				break;
			}
		}
		if (l == 0) {
			this.end = 1;
		}
	}

	// ----------set visted and check if end and push in stack---------//
	public void setVistedDFS(int x, int y) {
		if (this.map[y][x] == 'E') {
			this.flag = 1;
		}
		this.map[y][x] = '#';
		this.way[counter][0] = y;
		this.way[counter][1] = x;
		// System.out.println(y+" "+x);
		t.push(this.way[this.counter]);
		counter++;
	}

	// ----------------------------DFS---------------------------------//
	public void DFS() {
		while (!t.isEmpty() && this.flag == 0) {
			// down
			if (this.y + 1 < n && this.map[y + 1][x] != '#') {
				this.y++;
				this.setVistedDFS(this.x, this.y);
			} else
			// right
			if (this.x + 1 < m && this.map[y][x + 1] != '#') {
				this.x++;
				this.setVistedDFS(this.x, this.y);
			} else
			// up
			if (this.y - 1 >= 0 && this.map[y - 1][x] != '#') {
				this.y--;
				this.setVistedDFS(this.x, this.y);
			} else
			// left
			if (this.x - 1 >= 0 && this.map[y][x - 1] != '#') {
				this.x--;
				this.setVistedDFS(this.x, this.y);
			} else {
				t.pop();
				int[] arr = new int[2];
				if (t.isEmpty()) {
					break;
				}
				arr = (int[]) t.peek();
				this.y = arr[0];
				this.x = arr[1];
			}
		}
	}

	// -------set visted and check if end and push in queue-----------//
	public void setVistedBFS(int x, int y) {
		if (this.map[y][x] == 'E') {
			this.flag = 1;
		}
		this.map[y][x] = '#';
		this.way[counter][0] = y;
		this.way[counter][1] = x;
		// System.out.println(y+" "+x);
		q.enqueue(this.way[this.counter]);
		counter++;
	}

	// -----------------------------BFS-------------------------------//
	public void BFS() {
		while (!q.isEmpty() && flag == 0) {
			int[] arr = new int[2];
			arr = (int[]) q.dequeue();
			this.y = arr[0];
			this.x = arr[1];
			// down
			if (this.y + 1 < n && this.map[y + 1][x] != '#') {
				this.setVistedBFS(this.x, this.y + 1);
			}
			// right
			if (this.x + 1 < m && this.map[y][x + 1] != '#') {
				this.setVistedBFS(this.x + 1, this.y);
			}
			// up
			if (this.y - 1 >= 0 && this.map[y - 1][x] != '#') {
				this.setVistedBFS(this.x, this.y - 1);
			}
			// left
			if (this.x - 1 >= 0 && this.map[y][x - 1] != '#') {
				this.setVistedBFS(this.x - 1, this.y);
			}
		}
	}
}
