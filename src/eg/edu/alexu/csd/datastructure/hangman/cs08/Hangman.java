package eg.edu.alexu.csd.datastructure.hangman.cs08;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * @author ahmed
 *
 */

public class Hangman implements IHangman {

	private String[] words = new String[1000];
	// private String[] dic = new String[1000];
	public String secretword = "try";
	private String dashedWord;
	private int noOfWrongAnswers = 0;
	private int maxwrong;
	// private int counter;

	// copy the dictionary into an array of strings
	public void setDictionary(String[] words) {

		this.words = words;

	}

	// select a random string from the array and check if it equals null
	public String selectRandomSecretWord() {

		while (this.words[0] != null) {
			Random index = new Random();
			this.secretword = words[index.nextInt(this.words.length)];
			while (this.secretword == null) {
				this.secretword = words[index.nextInt(this.words.length)];
			}
			this.dashedWord = this.secretword;
			this.dashingword();
			return this.secretword;
		}
		return null;

	}

	// see if the user enters a right letter
	public String guess(Character c) {

		if (this.checkLoss() == 0) {
			return null;
		}
		if (this.checkChar(c) == 0) {
			this.noOfWrongAnswers++;
		}
		return this.dashedWord;

	}

	// set max wrong answers to 5
	public void setMaxWrongGuesses(Integer max) {

		this.maxwrong = max;
	}

	// creat seen dashed word
	public void dashingword() {

		char[] dashingCharArray = this.dashedWord.toCharArray();
		for (int i = 0; i < this.secretword.length(); i++) {
			dashingCharArray[i] = '-';
		}
		this.dashedWord = String.valueOf(dashingCharArray);

	}

	public int checkLoss() {

		if (this.noOfWrongAnswers == this.maxwrong - 1) {
			return 0;
		}
		return 1;

	}

	public int checkChar(char c) {

		int flag = 0;
		for (int i = 0; i < this.secretword.length(); i++) {
			if (this.secretword.charAt(i) == Character.toUpperCase(c)
					|| this.secretword.charAt(i) == Character.toLowerCase(c)) {
				char[] dashcar = this.dashedWord.toCharArray();
				dashcar[i] = Character.toUpperCase(c);
				this.dashedWord = String.valueOf(dashcar);
				flag = 1;
			}
		}
		return flag;

	}

	/*
	 * //print seen word public void printdashed(){
	 * 
	 * char[] dashedarr = dash.toCharArray();
	 * 
	 * for(int i=0;i<dash.length();i++){ System.out.print(dashedarr[i]+" "); }
	 * System.out.println(""); }
	 * 
	 * //incremets number of wrong answers by 1 public int wrong(){
	 * 
	 * wronganswers++;
	 * 
	 * return wronganswers; }
	 * 
	 * //check case of win public Boolean check(){
	 * 
	 * for(int i =0;i<secretword.length();i++){ if(dash.charAt(i)=='_'){ return
	 * true; } }
	 * 
	 * return false ; }
	 * 
	 * //readfrom file public String[] readfromfile() throws IOException{
	 * 
	 * int bufferSize = 8 * 1024;
	 * 
	 * BufferedReader bufferedReader = new BufferedReader( new
	 * FileReader("Dictionary.txt"), bufferSize);
	 * 
	 * String line = bufferedReader.readLine();
	 * 
	 * counter=0;
	 * 
	 * while(line != null) { dic[counter]=line.toLowerCase(); counter++; line =
	 * bufferedReader.readLine(); }
	 * 
	 * return dic; }
	 */
}
