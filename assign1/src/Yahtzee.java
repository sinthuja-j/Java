
//This class performs the scoring of the game

public class Yahtzee extends Dice {
	//initalize the dice array as object Dice
	private Dice[] dice= new Dice[5];  
	public Yahtzee() {
		//roll the dice for random values
		for (int i =0; i <5; i++) {
			this.dice[i]= new Dice(); 
			this.dice[i].roll(); 
		}
		
	}
	//overloaded method
	public Yahtzee(Dice[] dice) {
		System.arraycopy(dice, 0, this.dice, 0, 5);
	
	}
	
	private final int[] counters= new int[6];
	//Counts the number of dice and returns the array with counters of the number of die that show a value from 1-6
	public int[] getValueCount() {
		//initalize the index for the array
		for (int i=0; i < 6; i++) {
			this.counters[i] =0;
		}
		//accumalate the counters if they show a value from 1-6
		for (Dice die_object : dice) {
			this.counters[die_object.getValue()-1]++;
		}
		return this.counters;
	}
	//initalizing the score values array
	private final int[] score_array = new int[13]; 
	
	//array that includes 13 score options
	public int[] getScoreOptions() {
		this.getValueCount();
		for (int i=0; i < 6; i++) {
			score_array[i] = counters[i] * (i+1) ; 
		}
		// three of a kind
		for (int value : counters) {
			if (value >= 3) {
				for (int i=0; i<=5; i++) {
					score_array[6] +=counters[i] * (i+1); 
				}
				break;
			}
		}
		//four of a kind
		for (int value : counters ) {
			if (value >= 4) {
				for (int i=0; i <=5; i++) {
					score_array[7] += counters[i] * (i+1);
				}
				break;
			}
		}
		//full house
		int two_dice = 0; 
		int three_dice= 0;
		for (int value : counters) {
			if (value == 2) {
				two_dice= 1;
			}
			if (value == 3) {
				three_dice= 1;
			}
		}
		if (two_dice == 1 && three_dice == 1) {
			score_array[8] = 25; 
		}
		
		//small straight
		for (int i=0; i< 3; i++) {
			if (counters[i] > 0 && counters[i+1] > 0 && counters[i+2] > 0 && counters[i+3] > 0) {
				score_array[9]= 30; 
			}
		}
		//large straight
		for (int i=0; i <2; i++) {
			if(counters[i] > 0 && counters[i+1] > 0 && counters[i+2] > 0 && counters[i+3] > 0 && counters[i+4] > 0) {
				score_array[10] = 40; 
			}
		}
		//yahtzee
		for (int values : counters) {
			if (values >=5) {
				score_array[11] = 50; 
				break;
			}
		}
		//chance
		for (int i = 0; i <= 5; i++ ) {
			score_array[12] += score_array[i]; 
		}
		return score_array; 
		
	}
	public int[] score() {
		//returns int array with the maximum value in the score and its corresponding index
		int [] score_array= getScoreOptions();
		int[] max_values = {0,0}; 
		//finding the max value and its index
		for (int i=12; i>= 0; i--) {
			if(score_array[i] >= max_values[0]) {
				max_values[0]= score_array[i]; 
				max_values[1]= i; 
			}
		}
		return max_values;
		
	}
	
	//equals method- returns true if this array and other array are equal, if even out of order
	public boolean equals(Yahtzee other) {
		for (int i=0; i < 6; i++) {
			if(this.getValueCount()[i] != other.getValueCount()[i]) {
				return false;
			}
		}
		return true; 
		
	}
	//to string method that returns in format Dice: {x,x,x,x,x}
	public String toString() {
		return ("Dice: {" + dice[0].getValue() + ", " + dice[1].getValue() + ", " + dice[2].getValue() + ", " + dice[3].getValue() + ", " + dice[4].getValue() + "}"); 
	}



public static void main(String[] args) {
	
	Yahtzee game1, game2, game3;
	
	game1 = new Yahtzee();
	game2 = new Yahtzee(new Dice[] {new Dice(2), new Dice(5), new Dice(3), new Dice(5), new Dice(6)});
	game3 = new Yahtzee(new Dice[] {new Dice(6), new Dice(1), new Dice(1), new Dice(5), new Dice(2)});

	System.out.println(game1); 
	System.out.println(game2); 
	System.out.println(game3); 
	
	if (game1.equals("Dice: {2, 1, 6, 5, 1}")) {
		System.out.println("Test 1 Passed");
	} else {
		System.out.println("Test 1 Failed");
	}
	if (game1.toString().equals(game1)) {
		System.out.println("Test 1 Passed");
	} else {
		System.out.println("Test 1 Failed");
	}

}
}