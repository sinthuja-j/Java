/* 
 * Author: Sinthuja Jeevarajhan
 * Assignment 2: Wordle
 * Professor: Bryan Sarlo
 * Purpose: Program to simulate simple wordle game to allow users to guess a 'Mystery' Word
 */
public class WordLL {
	private Word mysteryWord;
	private LinearNode<Word> history;

	// WordLL constructor- takes in mystery word and initializes an empty history
	public WordLL(Word mystery) {
		history = new LinearNode<>();
		this.mysteryWord = mystery;
	}

	// tryWord method, takes in parameter guess object
	public boolean tryWord(Word guess) {

		boolean res = guess.labelWord(mysteryWord);
		if (history.getElement() == null) {
			history.setElement(guess);
		} else {
			// sets the guess to the front of the linked list
			LinearNode<Word> prev = history;
			LinearNode<Word> new_hist = new LinearNode<>();
			new_hist.setElement(guess);
			new_hist.setNext(prev);

			this.history = new_hist;

		}
		// returns if the guess is correct using the labelWord method
		return res;

	}

	// Overrides toString method; returns a list of word guesses using the same
	// format but with a new line after every guess
	public String toString() {
		String return_statement = "Word: ";
		LinearNode<Word> currNode = this.history;
		boolean next;

		do {
			Word word = currNode.getElement();

			return_statement += (word.toString() + "\n");

			currNode = currNode.getNext();

			if (currNode == null) {
				next = false;
			} else {
				next = currNode.getElement() != null;
			}
		} while (next);
		return return_statement.toString();
	}
}
