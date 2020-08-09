//package Lab5Student;

import java.util.ArrayList;

public class Queue<T> {
	
	private ArrayList<T> elements;
	
	Queue() {
		this.elements = new ArrayList<T>();
	}
	
	//Add an element to the end of the queue
	public void offer(T element) {
		//#TODO
		this.elements.add(element);

	}
	
	//Retrieve (but do NOT remove) an element from the start of the queue
	//If the queue is empty, return null
	public T peek() {
		//#TODO
		if(elements.size()!=0){
			return elements.get(0);
		}return null;

	}
	
	//Retrieve AND remove an element from the start of the queue
	//If the queue is empty, return null
	public T poll() {
		//#TODO
		if(elements.isEmpty()){
			return null;
		}
		return elements.remove(0);
		
	}
	
	
	public static class QueueRunner{
		public static void main(String[] args) {
			Queue queue = new Queue<String>();
			queue.offer("This");
			queue.offer("is");
			queue.offer("a");
			queue.offer("queue");
			
			System.out.println(queue.peek());
			System.out.println(queue.peek());
			System.out.println(queue.peek() + System.lineSeparator());
			
			System.out.println(queue.poll());
			System.out.println(queue.poll());
			System.out.println(queue.poll());
			System.out.println(queue.poll()+ System.lineSeparator());
			
			System.out.println(queue.poll());
			System.out.println(queue.peek());
			
		}
		
	}

}
