import java.io.IOException;
/*
 * Author: Sinthuja Jeevarajhan
 * Assignment 3: Pryamid Chambers with Stacks
 * Professor Sarlo
 * CS 1027
 * March 22 2022
 * Purpose: Program navigates through pryamid chamber to find the best route
 */

public class FindPath {
	private Map pyramidMap; 
	//constructor- uses fileName to create object
	public FindPath(String fileName) {
	try {
		Map temp_obj= new Map(fileName); 
		temp_obj.showMap();
		this.pyramidMap= temp_obj; 
		}
		//caught if file doesnt exist
		catch (IOException e) {
			e.printStackTrace();
		}
		//caught if there is an invalid character in the file
		catch (InvalidMapCharacterException e) {
			e.printStackTrace();
		}
		} 
	//path method finds a path from the entrance to all the treasure chambers that can be reached by fulfilling constraints
	public DLStack path() {
		//creates a new stack
		DLStack<Chamber> tmpstack= new DLStack<Chamber>(); 
		//sets the variables 
		Chamber entrance= pyramidMap.getEntrance(); 
		int numTreasures= pyramidMap.getNumTreasures(); 
		int foundTreasures= 0; 
		entrance.markPushed();
		tmpstack.push(entrance);
		Chamber c = null; 
		//navigates the path until the stack is empty
		if (tmpstack.isEmpty()) {
			return null; 
		}
		while (!(tmpstack.isEmpty())) {
			Chamber top= ((Chamber)tmpstack.peek()); 
			if (top.isTreasure()) {
				foundTreasures++; 
				if (foundTreasures == numTreasures) {
					break; 
				}
			}
			c= this.bestChamber(entrance);
			if (c != null) {
				entrance= c;
				c.markPushed();
				tmpstack.push(c); 
			
			}
			else {
				tmpstack.pop(); 
				entrance.markPopped();
			}
			
		}
		//returns the stack
		return tmpstack; 
		
	}
	//returns the value of pryamidMap
	public Map getMap() {
		return pyramidMap; 
	}
	//returns true if the chamber is dim- neighbourhing chambers have to be lit for the chamber to be dim
	public boolean isDim(Chamber currentChamber) {
		boolean checkNeighLighted= false; 
		//checks the 5 surrounding chambers
		for (int i=0; i < 6; i++) {
			if (currentChamber.getNeighbour(i) != null) {
				//checks if neighbouring chamber is lit
				if (currentChamber.getNeighbour(i).isLighted()) {
					checkNeighLighted= true; 
				}
			}
		}
		// returns true if these conditions are met
		if (!(currentChamber.isLighted()) && currentChamber != null && (!(currentChamber.isSealed())) && checkNeighLighted ) {
			return true; 	
		}
		//else returns false
		return false; 
	}
	
	//returns the best chamber to move from currentChamber whilst satisfying conditions
	public Chamber bestChamber(Chamber currentChamber) {
		
		for (int i=0; i< 6; i++) {
		if (currentChamber.getNeighbour(i) != null && (!(currentChamber.getNeighbour(i).isMarked()))) {
			if (currentChamber.getNeighbour(i).isTreasure()) {  
				return currentChamber.getNeighbour(i);
			}
		}
		}
		for (int i=0; i< 6; i++) {
			if (currentChamber.getNeighbour(i) != null && (!(currentChamber.getNeighbour(i).isMarked()))) {
				if (currentChamber.getNeighbour(i).isLighted()) {  
					return currentChamber.getNeighbour(i);
				}
			}
			}
		for (int i=0; i< 6; i++) {
			if (currentChamber.getNeighbour(i) != null && (!(currentChamber.getNeighbour(i).isMarked()))) {
				if (this.isDim(currentChamber.getNeighbour(i))) {  
					return currentChamber.getNeighbour(i);
				}
			}
			}
			
		return null; 
	}
	
		
		
	
}
