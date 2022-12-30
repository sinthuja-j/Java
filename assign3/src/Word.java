/* 
 * Author: Sinthuja Jeevarajhan
 * Assignment 2: Wordle
 * Professor: Bryan Sarlo
 * Purpose: Program to simulate simple wordle game to allow users to guess a 'Mystery' Word
 */
public class Word {
	// new node created to rep. first item in linked list
	private LinearNode<Letter> firstLetter = new LinearNode<>();

	// Word constructor
	public Word(Letter[] letters) {
		if (letters.length <= 0) {
			throw new IllegalArgumentException("Letters must exist");
		}
		// creates new node with these parameter; first Linear node, word from letters
		// parameter and index
		newNode(firstLetter, letters, 0);
	}

	// helper method that creates new node with given parameters
	private static void newNode(LinearNode<Letter> curr, Letter[] letters, int index) {
		// prevents index out of bounds exception
		if (index >= letters.length) {
			return;
		}
		// creates new node if index exists within length of letters
		if (curr.getElement() == null) {
			curr.setElement(letters[index]);
			curr.setNext(new LinearNode<>());
			newNode(curr.getNext(), letters, ++index);
		}

	}

	// Overrides toString method, returns String in format Word: (decorator) +
	// letter (decorator), etc.
	public String toString() {
		String return_statement = "Word: ";
		LinearNode<Letter> currNode = firstLetter;
		boolean next;

		do {
			return_statement += (currNode.getElement().toString() + " ");

			currNode = currNode.getNext();
			next = currNode.getNext() != null;
		} while (next);
		return return_statement;
	}

	// helper method
	private boolean contains(LinearNode<Letter> letter){
        LinearNode<Letter> currentNode = firstLetter;
        while(currentNode.getElement() != null){
            if(currentNode.getElement().equals(letter.getElement())){
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public boolean labelWord(Word mystery){
        LinearNode<Letter> otherNode = mystery.firstLetter;
        LinearNode<Letter> thisNode = this.firstLetter;
        boolean isEqual = true;
        while(true){
            if(thisNode == null || otherNode == null){
                if(thisNode == null && otherNode == null){
                    break;
                }
                isEqual = false;
                break;
            }
            if(thisNode.getElement().equals(otherNode.getElement())){
                thisNode.getElement().setCorrect();
            }
            else{
                if(mystery.contains(thisNode)){
                    thisNode.getElement().setUsed();
                }
                else{
                    thisNode.getElement().setUnused();
                }
                isEqual = false;
            }
            thisNode = thisNode.getNext();
            otherNode = otherNode.getNext();
        }
        return isEqual;
    }
}


