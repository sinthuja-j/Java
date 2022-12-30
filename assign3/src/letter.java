/* 
 * Author: Sinthuja Jeevarajhan
 * Assignment 2: Wordle
 * Professor: Bryan Sarlo
 * Purpose: Program to simulate simple wordle game to allow users to guess a 'Mystery' Word
 */
public class Letter {
	// initialize letter and label
	private char letter;
	private int label;
	// Declare constants for the label setting
	private final int UNSET = -1;
	private final int UNUSED = 0;
	private final int USED = 10;
	private final int CORRECT = 100;

	// Letter constructor, parameter c is set to letter, label is initialized to
	// unset
	public Letter(char c) {
		label = UNSET;
		letter = c;

	}

	// equals method; returns true if the 'letter' of the object and the letter in
	// this program are identical
	public boolean equals(Object otherObject) {
		// returns false if otherObject is not of the class Letter
		if (!(otherObject instanceof Letter)) {
			return false;
		}
		return ((Letter) otherObject).letter == this.letter;

	}

	// sets the visual representation of the label
	public String decorator() {
		// true if label is used
		if (this.label == USED) {
			return "+";
		}
		// true if label is unused
		if (this.label == UNUSED) {
			return "-";
		}
		// true if label is correct
		if (this.label == CORRECT) {
			return "!";
		}
		// true if label is unset
		if (this.label == UNSET) {
			return " ";
		} else {
			return null;
		}

	}

	// Overrides the toString method; returns in the format (decorator char) +
	// letter (decorator char)
	public String toString() {
		String return_var = "unset";
		if (this.decorator() == "+") {
			return_var = ("+" + this.letter + "+");
		}
		if (this.decorator() == "-") {
			return_var = ("-" + this.letter + "-");
		}
		if (this.decorator() == "!") {

			return_var = ("!" + this.letter + "!");
		}
		if (this.decorator() == " ") {
			return_var = (" " + this.letter + " ");
		}
		return return_var;
	}

	// sets label to unused
	public void setUnused() {
		label = UNUSED;
	}

	// sets label to used
	public void setUsed() {
		label = USED;
	}

	// sets label to correct
	public void setCorrect() {
		label = CORRECT;
	}

	// true if label is unused
	public boolean isUnused() {
		if (label == UNUSED) {
			return true;
		} else {
			return false;
		}
	}

	// Produces an array of objects of the class Letter from the string s given as a
	// parameter
	public static Letter[] fromString(String s) {
		char letter;
		// new array word with length of the String parameter s
		Letter[] word = new Letter[s.length()];
		for (int i = 0; i < s.length(); i++) {
			letter = s.charAt(i);
			// new object is created for each letter in String s
			Letter myObj = new Letter(letter);
			// ith entry of word is set to this new object
			word[i] = myObj;

		}
		return word;

	}

}
