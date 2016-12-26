package test.algo;

import java.util.Stack;

public class BST {

	private Node root;
	
	private static class Node{
		Node left, right;
		int data;
		public Node(int value){
			this.data = value;
			left = right = null;
		}
	}
	
	
	public BST(){
		root = null;
	}
	
	public boolean isEmpty(){
		if(root == null){
			return true;
		}
		return false;
	}
	
	public Node getRoot(){
		return root;
	}
	
	
	public int size(){
		
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		int size = 0;
		
		while(!stack.isEmpty() || current != null){
			if(current != null){
				stack.push(current);
				current = current.left;
			}else {
				size ++;
				current = stack.pop();
				current = current.right;
			}
			
		}
		
		return size;
		
	}
	
	public void add(int value){
		
		Node newNode = new Node(value);

		Node current = root;
		if(root.data == value){
			newNode.left = root;
			newNode.right = root.right;
			root = newNode;
		}// TODO
		
	}
	
	
	
	
}
