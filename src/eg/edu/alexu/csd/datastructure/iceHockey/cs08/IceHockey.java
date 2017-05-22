package eg.edu.alexu.csd.datastructure.iceHockey.cs08;

import java.awt.Point;
import java.util.Arrays;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**
 * @author ahmed
 *
 */
public class IceHockey implements IPlayersFinder {

	public char player;
	public int area;
	public String[] picture = new String[100];
	char booleanCharArray[][] = new char[1000][1000];
	public Point[] points = new Point[2500];

	public int teamCounter;
	public int noOfTeamPlayers;
	public int xIndex;
	public int yIndex;
	public int[] arrYIndex = new int[100];
	public int[] arrXIndex = new int[100];
	public int leftIndex;
	public int rightIndex;
	public int lowwerIndex;
	// public int[] centerXIndex = new int[100];
	// public int[] centerYIndex = new int[100];
	// public Point point = new Point();
	// public Point[] pointArr = new Point[100];
	// public int pointArrayCounter = 0;
	// public int indexXYArray[][] = new int[100][2];

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {

		this.picture = photo;
		if (this.picture == null) {
			return null;
		}
		// if(photo.length==0) {
		// return null;
		// }
		this.setValuesToPlayer(team);
		this.setValuesToThreShold(threshold);
		this.setCharArray();
		this.setPlayerIndexs();

		Point[] pointsToBeReturned = new Point[this.noOfTeamPlayers];
		for (int i = 0; i < this.noOfTeamPlayers; i++) {
			pointsToBeReturned[i] = points[i];
			Arrays.sort(pointsToBeReturned);
			if (this.noOfTeamPlayers == 0)
				return null;
			// this.sortArray();
			// this.setPoint();
		}
		return pointsToBeReturned;
	}

	// set the player
	public void setValuesToPlayer(int a) {

		String x;
		x = Integer.toString(a);
		this.player = x.charAt(0);

	}

	// set the thresold
	public void setValuesToThreShold(int a) {

		area = a;

	}

	// change the string[] into char[]
	public void setCharArray() {

		for (int i = 0; i < this.picture.length; i++) {
			this.booleanCharArray[i] = this.picture[i].toCharArray();
		}

	}

	/*
	 * public void SetCharArrayToBoolean() {
	 * 
	 * for(int i=0;i<this.picture.length;i++) { for(int
	 * j=0;j<this.picture[i].length();j++) {
	 * if(this.picture[i].charAt(j)==this.player) { this.booleanCharArray[i][j]
	 * = '!'; } } }
	 * 
	 * }
	 */

	// send the firs appeare of the player to dfsfunc.
	public void setPlayerIndexs() {

		for (int i = 0; i < this.picture.length; i++) {
			for (int j = 0; j < this.picture[i].length(); j++) {
				while (this.booleanCharArray[i][j] == this.player) {
					this.xIndex = j;
					this.yIndex = i;
					this.leftIndex = j;
					this.rightIndex = j;
					this.lowwerIndex = i;
					this.searchAdjecantCells(i, j);
					this.checkValidity();
				}
			}
		}

	}

	// flag adjecant players and calculate their no. and send it to check func.
	public void searchAdjecantCells(int y, int x) {

		this.teamCounter++;
		this.booleanCharArray[y][x] = '!';
		if (x + 1 < this.picture[0].length()) {
			if (this.booleanCharArray[y][x + 1] == this.player) {
				if (x + 1 > this.leftIndex) {
					this.leftIndex = x + 1;
				}
				this.searchAdjecantCells(y, x + 1);
			}
		}
		if (x - 1 > 0) {
			if (this.booleanCharArray[y][x - 1] == this.player) {
				if (x - 1 < this.rightIndex) {
					this.rightIndex = x - 1;
				}
				this.searchAdjecantCells(y, x - 1);
			}
		}
		if (y + 1 < this.picture.length) {
			if (this.booleanCharArray[y + 1][x] == this.player) {
				if (y + 1 > this.lowwerIndex) {
					this.lowwerIndex = y + 1;
				}
				this.searchAdjecantCells(y + 1, x);
			}
		}
		if (y - 1 > 0) {
			if (this.booleanCharArray[y - 1][x] == this.player) {
				this.searchAdjecantCells(y - 1, x);
			}
		}
		/*
		 * if(y == this.yIndex && x ==this.xIndex) { this.checkValidity(); }
		 */

	}

	// check if the area is greater than the threshold or equal
	public void checkValidity() {

		if (this.teamCounter * 4 >= this.area) {

			this.points[this.noOfTeamPlayers] = this.calculateCenter(this.leftIndex, this.rightIndex, this.lowwerIndex,
					this.yIndex);
			// this.calculateCenter(this.rightIndex, this.leftIndex,
			// this.lowwerIndex, this.yIndex);
			// this.setXYIndexArray();
			this.noOfTeamPlayers++;
			this.teamCounter = 0;

		}

	}

	public Point calculateCenter(int maxRow, int minRow, int maxColumn, int minColumn) {
		Point p = new Point(minColumn + maxColumn + 1, minRow + maxRow + 1);
		return p;
	}

	public void setReturnedPoints() {
		Point[] pointsToBeReturned = new Point[this.noOfTeamPlayers];
		for (int i = 0; i < this.noOfTeamPlayers; i++) {
			pointsToBeReturned[i] = points[i];
		}
	}

	/*
	 * public void setXYIndexArray() {
	 * 
	 * //this.arrYIndex[this.noOfTeamPlayers] = this.yIndex;
	 * //this.arrXIndex[this.noOfTeamPlayers] = this.xIndex;
	 * this.indexXYArray[this.noOfTeamPlayers][0] = this.xIndex;
	 * this.indexXYArray[this.noOfTeamPlayers][1] = this.yIndex;
	 * 
	 * }
	 */

	// calculate the center of the player
	/*
	 * public void calculateCenter(int leftindex, int rightindex, int
	 * lowwerindex, int upperindex) {
	 * 
	 * this.centerXIndex[this.noOfTeamPlayers] = (leftIndex * 2 + 1 + rightIndex
	 * * 2 + 1) / 2; this.centerYIndex[this.noOfTeamPlayers] = (lowwerIndex * 2
	 * + 1 + upperindex * 2 + 1) / 2;
	 * System.out.println(this.centerXIndex[this.noOfTeamPlayers - 1]);
	 * System.out.println(this.centerYIndex[this.noOfTeamPlayers - 1]);
	 * this.set2DIndexCenterArray(this.centerXIndex[this.noOfTeamPlayers],
	 * this.centerYIndex[this.noOfTeamPlayers]); //
	 * this.setPoint(this.centerXIndex[this.noOfTeamPlayers], //
	 * this.centerYIndex[this.noOfTeamPlayers] );
	 * 
	 * }
	 * 
	 * // set the center int array[index][x/y] public void
	 * set2DIndexCenterArray(int x, int y) {
	 * 
	 * this.indexXYArray[this.noOfTeamPlayers][0] = x;
	 * this.indexXYArray[this.noOfTeamPlayers][1] = y;
	 * 
	 * }
	 * 
	 * // arrange the center points public void sortArray() {
	 * 
	 * for (int i = 0; i < this.noOfTeamPlayers - 1; i++) { for (int j = 0; j <
	 * this.noOfTeamPlayers - i - 1; j++) { if (this.indexXYArray[j][0] >
	 * this.indexXYArray[j + 1][0]) { this.replaceIndex(j); } if
	 * ((this.indexXYArray[j][0] == this.indexXYArray[j + 1][0])) { if
	 * (this.indexXYArray[j][1] > this.indexXYArray[j + 1][1]) {
	 * this.replaceIndex(j); } } } } }
	 * 
	 * // replace 2 arrays public void replaceIndex(int index) { int[] temp;
	 * temp = this.indexXYArray[index]; this.indexXYArray[index] =
	 * this.indexXYArray[index + 1]; this.indexXYArray[index + 1] = temp; }
	 * 
	 * // set center point public void setPoint() {
	 * 
	 * for (int i = 0; i < this.noOfTeamPlayers; i++) { this.point.y =
	 * this.indexXYArray[i][1]; this.point.x = this.indexXYArray[i][0];
	 * this.SetCenterPointArray(this.point); } }
	 * 
	 * // set point array of center public void SetCenterPointArray(Point x) {
	 * 
	 * this.pointArr[this.pointArrayCounter] = x; this.pointArrayCounter++;
	 * 
	 * }
	 * 
	 * /* public void StringToCharArray(String x) {
	 * 
	 * this.stringTochars = x.toCharArray();
	 * this.toBooleanCharArray(this.stringTochars);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void toBooleanCharArray(char[] x){
	 * 
	 * for(int i=0;i<x.length;i++) { if(x[i]==this.player) {
	 * this.stringTochars[i]='t'; }else { this.stringTochars[i]='f'; } }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void setBooleanPicture(){
	 * 
	 * for(int i=0;i<this.picture.length;i++) {
	 * this.StringToCharArray(this.picture[i]); this.booleanPicture[i] =
	 * this.stringTochars.toString(); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void dfsFunc(int x ,int y){
	 * 
	 * this.teamCounter++; this.booleanPicture[x].charAt(y)='!';
	 * if(booleanPicture[x+1].charAt(y)==this.player) { this.dfsFunc(x+1 ,y); }
	 * if(booleanPicture[x-1].charAt(y)==this.player) { this.dfsFunc(x-1 ,y); }
	 * if(booleanPicture[x].charAt(y+1)==this.player) { this.dfsFunc(x ,y+1); }
	 * if(booleanPicture[x].charAt(y-1)==this.player) { this.dfsFunc(x ,y-1); }
	 * this.checkValidity(); }
	 * 
	 * 
	 * 
	 * public void checkValidity() { if(this.teamCounter >= this.area) {
	 * 
	 * }
	 */

}