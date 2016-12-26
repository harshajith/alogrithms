package test.algo;

public class LinkedList {
	
	Node head;

	public void add(int x){
		
		if(head == null){
			head = new Node(x);
			return;
		} 
		
		tail().next = new Node(x);
	}

	public Node tail(){
		Node tail = head;
		while(tail.getNext() != null){
			tail = tail.getNext();
		}
		return tail;
	}
	
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}
	
	

	
	private static class Node{
		private Integer data;
		private Node next;
		
		public Node(Integer data){
			this.data = data;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node node){
			this.next = node;
		}
		
		public void setData(Integer value){
			this.data = value;
		}
		
		public Integer getData(){
			return data;
		}
	}
}
