/*
 * Purpose: Scrabble game where there are 7 randomly selected tiles, scoring is performed for each possible word
 * Author: Sinthuja Jeevarajhan
 * Course: CS 1027 Summer
 * Professor: Luke Russell
 */

//Import the required libraries
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;

public class Scrabble {

	// stores the values of the 7 tiles
	private Tile[] tiles;
	// list of the scores for each alpha character
	private final int[] scores = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

	// constructor- uses the pickup method to set the tiles to 7 random characters
	public Scrabble() {
		tiles = new Tile[7];
		for (int i = 0; i < tiles.length; i++) {
			this.tiles[i] = new Tile();
			tiles[i].pickup();
		}

	}

	// overloaded constructor- initalizes tile to the value of the argument
	public Scrabble(Tile[] argument) {
		tiles = argument;
	}

	// returns the tiles concatonated into a singular string
	public String getLetters() {
		String string = "";
		for (int i = 0; i < tiles.length; i++) {
			string += tiles[i].getValue();
		}
		// returns the string of characters
		return string;
	}

	// helper method- checks if 'tiles' can be made from the parameter 'collins'
	private boolean checkEquals(String tiles, String collins) {
		int[] thisLetters = new int[26];
		int[] otherLetters = new int[26];

		// count the letters in the tiles and increment the counter in the respective array
		for (int i = 0; i < tiles.length(); i++) {
			if (tiles.charAt(i) == 'A') {
				thisLetters[0]++;
			}
			if (tiles.charAt(i) == 'B') {
				thisLetters[1]++;
			}
			if (tiles.charAt(i) == 'C') {
				thisLetters[2]++;
			}
			if (tiles.charAt(i) == 'D') {
				thisLetters[3]++;
			}
			if (tiles.charAt(i) == 'E') {
				thisLetters[4]++;
			}
			if (tiles.charAt(i) == 'F') {
				thisLetters[5]++;
			}
			if (tiles.charAt(i) == 'G') {
				thisLetters[6]++;
			}
			if (tiles.charAt(i) == 'H') {
				thisLetters[7]++;
			}
			if (tiles.charAt(i) == 'I') {
				thisLetters[8]++;
			}
			if (tiles.charAt(i) == 'J') {
				thisLetters[9]++;
			}
			if (tiles.charAt(i) == 'K') {
				thisLetters[10]++;
			}
			if (tiles.charAt(i) == 'L') {
				thisLetters[11]++;
			}
			if (tiles.charAt(i) == 'M') {
				thisLetters[12]++;
			}
			if (tiles.charAt(i) == 'N') {
				thisLetters[13]++;
			}
			if (tiles.charAt(i) == 'O') {
				thisLetters[14]++;
			}
			if (tiles.charAt(i) == 'P') {
				thisLetters[15]++;
			}
			if (tiles.charAt(i) == 'Q') {
				thisLetters[16]++;
			}
			if (tiles.charAt(i) == 'R') {
				thisLetters[17]++;
			}
			if (tiles.charAt(i) == 'S') {
				thisLetters[18]++;
			}
			if (tiles.charAt(i) == 'T') {
				thisLetters[19]++;
			}
			if (tiles.charAt(i) == 'U') {
				thisLetters[20]++;
			}
			if (tiles.charAt(i) == 'V') {
				thisLetters[21]++;
			}
			if (tiles.charAt(i) == 'W') {
				thisLetters[22]++;
			}
			if (tiles.charAt(i) == 'X') {
				thisLetters[23]++;
			}
			if (tiles.charAt(i) == 'Y') {
				thisLetters[24]++;
			}
			if (tiles.charAt(i) == 'Z') {
				thisLetters[25]++;
			}
		}

		// count the letters in the collins word and increment the counter in the
		// respective array
		for (int i = 0; i < collins.length(); i++) {
			if (collins.charAt(i) == 'A') {
				otherLetters[0]++;
			}
			if (collins.charAt(i) == 'B') {
				otherLetters[1]++;
			}
			if (collins.charAt(i) == 'C') {
				otherLetters[2]++;
			}
			if (collins.charAt(i) == 'D') {
				otherLetters[3]++;
			}
			if (collins.charAt(i) == 'E') {
				otherLetters[4]++;
			}
			if (collins.charAt(i) == 'F') {
				otherLetters[5]++;
			}
			if (collins.charAt(i) == 'G') {
				otherLetters[6]++;
			}
			if (collins.charAt(i) == 'H') {
				otherLetters[7]++;
			}
			if (collins.charAt(i) == 'I') {
				otherLetters[8]++;
			}
			if (collins.charAt(i) == 'J') {
				otherLetters[9]++;
			}
			if (collins.charAt(i) == 'K') {
				otherLetters[10]++;
			}
			if (collins.charAt(i) == 'L') {
				otherLetters[11]++;
			}
			if (collins.charAt(i) == 'M') {
				otherLetters[12]++;
			}
			if (collins.charAt(i) == 'N') {
				otherLetters[13]++;
			}
			if (collins.charAt(i) == 'O') {
				otherLetters[14]++;
			}
			if (collins.charAt(i) == 'P') {
				otherLetters[15]++;
			}
			if (collins.charAt(i) == 'Q') {
				otherLetters[16]++;
			}
			if (collins.charAt(i) == 'R') {
				otherLetters[17]++;
			}
			if (collins.charAt(i) == 'S') {
				otherLetters[18]++;
			}
			if (collins.charAt(i) == 'T') {
				otherLetters[19]++;
			}
			if (collins.charAt(i) == 'U') {
				otherLetters[20]++;
			}
			if (collins.charAt(i) == 'V') {
				otherLetters[21]++;
			}
			if (collins.charAt(i) == 'W') {
				otherLetters[22]++;
			}
			if (collins.charAt(i) == 'X') {
				otherLetters[23]++;
			}
			if (collins.charAt(i) == 'Y') {
				otherLetters[24]++;
			}
			if (collins.charAt(i) == 'Z') {
				otherLetters[25]++;
			}
		}
		// if there are not enough tiles to form the letter the method returns false
		for (int i = 0; i < 26; i++) {
			if (thisLetters[i] < otherLetters[i]) {
				return false;
			}
		}
		// if there are enough tiles to create the word- the method will return true
		return true;

	}

	// getWords method- returns a list of words that can be made from the tiles
	public ArrayList<String> getWords() throws IOException {
		ArrayList<String> words = new ArrayList<>();
		// read the list of words from the collins dictionary
		FileInputStream fstream = new FileInputStream("CollinsScrabbleWords2019.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		// call the getLetters method to retrieve the tiles letter in a singular string
		String tiles = this.getLetters();

		String[] collinsWords = new String[279496];
		for (int i = 0; i < collinsWords.length; i++) {
			// read the word from the file
			collinsWords[i] = br.readLine();
			// call the checkEquals helper method- if true then add the Collins word to the
			// array list
			if (checkEquals(tiles, collinsWords[i])) {
				words.add(collinsWords[i]);
			}
		}
		// close the file
		br.close();
		// return the array list of words
		return words;

	}

	// getScores method- calculates the scores of each word and returns an array in ascending order
	public int[] getScores() throws IOException {
		ArrayList<String> list;
		list = getWords();
		char letter;
		int score;
		int[] scoresNew = new int[list.size()];
		int j = 0;
		// iterate and calculate the score for each word- using the appropriate score value
		for (String word : list) {
			score = 0;
			for (int i = 0; i < word.length(); i++) {
				letter = word.charAt(i);
				if (letter == 'A') {
					score += scores[0];
				}
				if (letter == 'B') {
					score += scores[1];
				}
				if (letter == 'C') {
					score += scores[2];
				}
				if (letter == 'D') {
					score += scores[3];
				}
				if (letter == 'E') {
					score += scores[4];
				}
				if (letter == 'F') {
					score += scores[5];
				}
				if (letter == 'G') {
					score += scores[6];
				}
				if (letter == 'H') {
					score += scores[7];
				}
				if (letter == 'I') {
					score += scores[8];
				}
				if (letter == 'J') {
					score += scores[9];
				}
				if (letter == 'K') {
					score += scores[10];
				}
				if (letter == 'L') {
					score += scores[11];
				}
				if (letter == 'M') {
					score += scores[12];
				}
				if (letter == 'N') {
					score += scores[13];
				}
				if (letter == 'O') {
					score += scores[14];
				}
				if (letter == 'P') {
					score += scores[15];
				}
				if (letter == 'Q') {
					score += scores[16];
				}
				if (letter == 'R') {
					score += scores[17];
				}
				if (letter == 'S') {
					score += scores[18];
				}
				if (letter == 'T') {
					score += scores[19];
				}
				if (letter == 'U') {
					score += scores[20];
				}
				if (letter == 'V') {
					score += scores[21];
				}
				if (letter == 'W') {
					score += scores[22];
				}
				if (letter == 'X') {
					score += scores[23];
				}
				if (letter == 'Y') {
					score += scores[24];
				}
				if (letter == 'Z') {
					score += scores[25];
				}

			}
			// add the score to the array
			scoresNew[j] = score;
			j++;
		}
		// sort the array into ascending order
		Arrays.sort(scoresNew);
		// return the array of words
		return scoresNew;
	}

	// equals method- checks if tiles of identical length are equal to our set of tiles
	public boolean equals(Scrabble other) {
		String tiles = this.getLetters();
		String collins = other.getLetters();
		int[] thisLetters = new int[26];
		int[] otherLetters = new int[26];

		for (int i = 0; i < tiles.length(); i++) {
			if (tiles.charAt(i) == 'A') {
				thisLetters[0]++;
			}
			if (tiles.charAt(i) == 'B') {
				thisLetters[1]++;
			}
			if (tiles.charAt(i) == 'C') {
				thisLetters[2]++;
			}
			if (tiles.charAt(i) == 'D') {
				thisLetters[3]++;
			}
			if (tiles.charAt(i) == 'E') {
				thisLetters[4]++;
			}
			if (tiles.charAt(i) == 'F') {
				thisLetters[5]++;
			}
			if (tiles.charAt(i) == 'G') {
				thisLetters[6]++;
			}
			if (tiles.charAt(i) == 'H') {
				thisLetters[7]++;
			}
			if (tiles.charAt(i) == 'I') {
				thisLetters[8]++;
			}
			if (tiles.charAt(i) == 'J') {
				thisLetters[9]++;
			}
			if (tiles.charAt(i) == 'K') {
				thisLetters[10]++;
			}
			if (tiles.charAt(i) == 'L') {
				thisLetters[11]++;
			}
			if (tiles.charAt(i) == 'M') {
				thisLetters[12]++;
			}
			if (tiles.charAt(i) == 'N') {
				thisLetters[13]++;
			}
			if (tiles.charAt(i) == 'O') {
				thisLetters[14]++;
			}
			if (tiles.charAt(i) == 'P') {
				thisLetters[15]++;
			}
			if (tiles.charAt(i) == 'Q') {
				thisLetters[16]++;
			}
			if (tiles.charAt(i) == 'R') {
				thisLetters[17]++;
			}
			if (tiles.charAt(i) == 'S') {
				thisLetters[18]++;
			}
			if (tiles.charAt(i) == 'T') {
				thisLetters[19]++;
			}
			if (tiles.charAt(i) == 'U') {
				thisLetters[20]++;
			}
			if (tiles.charAt(i) == 'V') {
				thisLetters[21]++;
			}
			if (tiles.charAt(i) == 'W') {
				thisLetters[22]++;
			}
			if (tiles.charAt(i) == 'X') {
				thisLetters[23]++;
			}
			if (tiles.charAt(i) == 'Y') {
				thisLetters[24]++;
			}
			if (tiles.charAt(i) == 'Z') {
				thisLetters[25]++;
			}
		}
		for (int i = 0; i < collins.length(); i++) {
			if (collins.charAt(i) == 'A') {
				otherLetters[0]++;
			}
			if (collins.charAt(i) == 'B') {
				otherLetters[1]++;
			}
			if (collins.charAt(i) == 'C') {
				otherLetters[2]++;
			}
			if (collins.charAt(i) == 'D') {
				otherLetters[3]++;
			}
			if (collins.charAt(i) == 'E') {
				otherLetters[4]++;
			}
			if (collins.charAt(i) == 'F') {
				otherLetters[5]++;
			}
			if (collins.charAt(i) == 'G') {
				otherLetters[6]++;
			}
			if (collins.charAt(i) == 'H') {
				otherLetters[7]++;
			}
			if (collins.charAt(i) == 'I') {
				otherLetters[8]++;
			}
			if (collins.charAt(i) == 'J') {
				otherLetters[9]++;
			}
			if (collins.charAt(i) == 'K') {
				otherLetters[10]++;
			}
			if (collins.charAt(i) == 'L') {
				otherLetters[11]++;
			}
			if (collins.charAt(i) == 'M') {
				otherLetters[12]++;
			}
			if (collins.charAt(i) == 'N') {
				otherLetters[13]++;
			}
			if (collins.charAt(i) == 'O') {
				otherLetters[14]++;
			}
			if (collins.charAt(i) == 'P') {
				otherLetters[15]++;
			}
			if (collins.charAt(i) == 'Q') {
				otherLetters[16]++;
			}
			if (collins.charAt(i) == 'R') {
				otherLetters[17]++;
			}
			if (collins.charAt(i) == 'S') {
				otherLetters[18]++;
			}
			if (collins.charAt(i) == 'T') {
				otherLetters[19]++;
			}
			if (collins.charAt(i) == 'U') {
				otherLetters[20]++;
			}
			if (collins.charAt(i) == 'V') {
				otherLetters[21]++;
			}
			if (collins.charAt(i) == 'W') {
				otherLetters[22]++;
			}
			if (collins.charAt(i) == 'X') {
				otherLetters[23]++;
			}
			if (collins.charAt(i) == 'Y') {
				otherLetters[24]++;
			}
			if (collins.charAt(i) == 'Z') {
				otherLetters[25]++;
			}
		}
		// if the respective letter counts are not equal the method will return false
		for (int i = 0; i < thisLetters.length; i++) {
			if (thisLetters[i] != otherLetters[i]) {
				return false;
			}
		}
		// else it returns true
		return true;
	}
}
