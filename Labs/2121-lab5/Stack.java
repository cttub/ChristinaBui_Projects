//package Lab5Student;

import java.util.ArrayList;

public class Stack <T> {
	private ArrayList<T> elements;
	
	public Stack() {
		this.elements = new ArrayList<T>();
	}
	
	public int getSize() {
		return this.elements.size();
	}
	
	//Check if the stack is empty, return a boolean
	//#TODO specify access modifier and return type
	public boolean isEmpty() {
		//#TODO
		if(elements.isEmpty()){
			return true;
		}return false;
	}
	
	//Push an item to the top of the stack
	//#TODO specify access modifier and return type
	public void push(T item) {
		//#TODO
		this.elements.add(item);
	}
	
	//Return but do NOT remove the item at the top of the stack
	//If the stack is empty, return null
	//#TODO specify access modifier and return type
	public T peek() {

		//#TODO
		if(elements.size()!=0){
			return elements.get(elements.size()-1);
		}return null;
	}
	
	//Return AND remove the item at the top of the stack
	//If the stack is empty, return null
	//#TODO specify access modifier and return type
	public T pop() {
		//#TODO
		if(elements.isEmpty()){
			return null;
		}
		return elements.remove(elements.size()-1);
		
	}
	
	@Override
	public String toString() {
		String returnString = "";
		for (int i = 0; i < this.elements.size(); i++)
		{
			returnString = returnString + this.elements.get(i) + "\n";
		}
		return returnString;
	}
	
	public static class StackRunner{
		public static void main(String[] args) {
			Stack<String> stack = new Stack<String>();
			stack.push("This");
			stack.push("is");
			stack.push("a");
			stack.push("stack");
			System.out.println(stack.toString());
			
			stack.pop();
			stack.pop();
			System.out.println(stack.toString());
			
			stack.push("still");
			stack.push("a");
			stack.push("stack");
			System.out.println(stack.toString());
			
			System.out.println(stack.peek());
			System.out.println(stack.peek());
		}
		
	}
	
}
