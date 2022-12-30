/*
 * Purpose: This class represents a single Scrabble tile that will be used in the game
 * Author: Sinthuja Jeevarajhan
 * Course: CS 1027 Summer
 * Professor: Luke Russell
 */

import java.util.Random;

public class Tile {
	// Represents the value of a tile
	private char value;

	// public constructor- initalizes the value variable
	public Tile() {
		value = ' ';
	}

	// overloaded constructor- intializes the value variable with the parameter
	// value
	public Tile(char newValue) {
		value = newValue;
	}

	// sets value to a random character
	public void pickup() {
		// creates the random character
		Random random = new Random();
		String setOfCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int randomInt = random.nextInt(setOfCharacters.length());
		char randomChar = setOfCharacters.charAt(randomInt);

		// the random character is assigned to value
		value = randomChar;
	}

	// Accessor method- returns the value of the value variable
	public char getValue() {
		return value;
	}

}
