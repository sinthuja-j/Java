
/* 
 * Author: Sinthuja Jeevarajhan 
 * CS 1027 Assignment 1
 * Professor Sarlo
 * Purpose: To determine the possible scores of all 13 options in a game of Yahtzee when given the top of the 5 dice. 
 */
//This class represents the six-sided die that will be used in the game
public class Dice {
	// declare the value variable as private
	private int value;

	public Dice() {
		// initalize the value to -1
		value = -1;
	}

	// overloaded method, set the variable value to the given paramemeter
	public Dice(int value) {
		this.value = value;
	}

	// Generates a number between 1 and 6 and assigns it to the value variable
	public void roll() {
		RandomNumber random = new RandomNumber();
		value = random.getRandomNumber(1, 6);

	}

	// returns an int value of the variable, value
	public int getValue() {
		return value;
	}

}




