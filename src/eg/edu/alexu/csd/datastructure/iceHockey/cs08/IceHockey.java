package eg.edu.alexu.csd.datastructure.iceHockey.cs08;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**
 * @author ahmed
 *
 */
public class IceHockey implements IPlayersFinder {

	public int rightIndex = 0;
	public int leftIndex = 0;
	public int upIndex = 0;
	public int downIndex = 0;
	public int numOfPlayers = 0;
	public int numOfPoints = 0;
	
	public String[] picture = new String[1000];
	public int numOfRows;
	public int numOfColumns;
	public int[][] booleanPicture = new int[numOfRows][numOfColumns];
	public Point[] points = new Point[2500];
	
 
 
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
 
		this.picture = photo;
		this.numOfPlayers=0;
		this.numOfPoints=0;
		if (photo == null)
			return null;
		else {
			this.numOfColumns = this.picture[0].length();
			this.numOfRows = this.picture.length;
			team += '0';
			this.findPlayer(team,threshold);
			
			Point[] pointsToBeReturned = new Point[numOfPoints];
			for (int i = 0; i < numOfPoints; i++) {
				pointsToBeReturned[i] = points[i];
			}
 
			// sort points Array
			Arrays.sort(pointsToBeReturned, new Comparator<Point>() {
				public int compare(Point a, Point b) {
					int xComp = Integer.compare(a.x, b.x);
					if (xComp == 0)
						return Integer.compare(a.y, b.y);
					else
						return xComp;
				}
			});
			if (numOfPoints == 0)
				return null;
			return pointsToBeReturned;
		}
	}
	
	public void findPlayer(int team , int threshold){
		for (int i = 0; i < this.picture.length; i++) {
			for (int j = 0; j < this.picture[i].length(); j++) {
				this.numOfPlayers = 0;
				if (this.picture[i].charAt(j) == team && this.booleanPicture[i][j] == 0) {
					this.rightIndex = i;
					this.leftIndex = i;
					this.upIndex = j;
					this.downIndex = j;
					this.numOfPlayers++;
					this.booleanPicture[i][j] = 1;
					findAdjCells(this.picture, this.numOfRows,this. numOfColumns, i, j,this. booleanPicture, team); 
					if ((numOfPlayers * 4) >= threshold) {
						points[numOfPoints] = calculateCenter(rightIndex, leftIndex, upIndex, downIndex);
						numOfPoints++;
					}
				} else
					continue;
			}
		}
	}
	
 
	void findAdjCells(String[] photo, int Rows, int Columns, int x, int y, int[][] visited, int team) {
		// up
		if (x - 1 >= 0 && y >= 0 && this.booleanPicture[x - 1][y] == 0 && photo[x - 1].charAt(y) == team) {
			this.booleanPicture[x - 1][y] = 1;
			if (x - 1 <this. leftIndex)
				this.leftIndex = x - 1;
			this.numOfPlayers++;
			findAdjCells(photo,this.numOfRows,this.numOfColumns, x - 1, y,this.booleanPicture, team);
		}
 
		// down
		if (x + 1 < Rows  && this.booleanPicture[x + 1][y] == 0 && photo[x + 1].charAt(y) == team) {
			this.booleanPicture[x + 1][y] = 1;
			if (x + 1 >this.rightIndex)
				this.rightIndex = x + 1;
			this.numOfPlayers++;
			findAdjCells(photo,this.numOfRows,this.numOfColumns, x + 1, y,this.booleanPicture, team);
		}
 
		// right
		if ( y + 1 < Columns &&this. booleanPicture[x][y + 1] == 0 && photo[x].charAt(y + 1) == team) {
			this.booleanPicture[x][y + 1] = 1;
			if (y + 1 >this. upIndex)
				this.upIndex = y + 1;
			this.numOfPlayers++;
			findAdjCells(photo,this. numOfRows,this. numOfColumns, x, y + 1,this. booleanPicture, team);
		}
 
		// left
		if ( y - 1 >= 0 &&this. booleanPicture[x][y - 1] == 0 && photo[x].charAt(y - 1) == team) {
			this.booleanPicture[x][y - 1] = 1;
			if (y - 1 <this. downIndex)
				this.downIndex = y - 1;
			this.numOfPlayers++;
			findAdjCells(photo,this. numOfRows,this. numOfColumns, x, y - 1,this. booleanPicture, team);
		}
 
	}
	
	
	
 
	public Point calculateCenter(int maxRow, int minRow, int maxColumn, int minColumn) {
		Point p = new Point(minColumn + maxColumn + 1, minRow + maxRow + 1);
		return p;
	}

}