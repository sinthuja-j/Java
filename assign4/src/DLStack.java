/*
 * Author: Sinthuja Jeevarajhan
 * Assignment 3: Pryamid Chambers with Stacks
 * Professor Sarlo
 * CS 1027
 * March 22 2022
 * Purpose: Program creates a double linked stack with the implementation of the DLStackADT
 */

public class DLStack<T> implements DLStackADT<T> {
	DoubleLinkedNode<T> top; //reference to the top node in the stack
	int numItems; //ref to the number of items in the stack
	//DLStack constructor, top is set to null and numItems is set to 0
	public DLStack() {
		top = null;
		numItems= 0; 
	}
	//push method, adds the specfied dataitem to the top of the stack
	public void push(T dataItem) {
		//sets the data item as a node w variable temp
		DoubleLinkedNode<T> temp= new DoubleLinkedNode<T> (dataItem); 
		if (isEmpty()) {
			top = temp; 
			numItems++; 
			return; 
		}
		temp.setNext(top);
		numItems++; 
		top = temp;
	}
	//pop method, pops the item off the top of the stack
	public T pop() throws EmptyStackException {
		DoubleLinkedNode<T> temp; 
		// if stack is empty throw empty stack exception
		if (isEmpty()) {
			throw new EmptyStackException("empty"); 
		}
		//uses pop(int k) method to remove the node at index 1
		T returnval= top.getElement(); 
		top= top.getNext(); 
		numItems--; 
		return returnval; 
		
	}
	//pop item that removes item at index k 
	
	public T pop(int k) throws InvalidItemException {
		T curr; 
		if (k > numItems) {
			throw new InvalidItemException("k is larger than stack"); 
		}
		else if (k<= 0) {
			throw new InvalidItemException("invalid index"); 
		}
		for (int i=1 ; i < k; i++) {
			top = top.getNext(); 
		}
		curr= top.getElement(); 
		top= null;
		numItems--; 
		
		return curr;  
	
	}
	
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("empty"); 
		}
		T result= top.getElement();
		return result;
	}
	//returns true if stack is empty
	public boolean isEmpty() {
		if (numItems == 0 || top == null) {
			return true; 
		}
		else return false; 
	}
	//returns the number of items in the stack
	public int size() {
		return numItems; 
	}
	//returns the item at the top of stack without removing it
	public DoubleLinkedNode<T> getTop() {
		return top; 
	}
	//String representation of the stack
	public String toString() {
		//returned if the stack is empty
		String result= "["; 
		while (top.getPrevious() != null) {
			result+= top.getElement().toString() + ", "; 
		}
		result+=(top.getElement().toString()) + "]"; 
		return result; 
				
	}
	
	
}
