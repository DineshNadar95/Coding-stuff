import java.util.*;

class Node{
	private int data;
	private Node left;
	private Node right;
	
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public Node getLeftChild(){
		return left;
	}
	
	public Node getRightChild(){
		return right;
	}
	
	public void setLeftChild(Node left){
		this.left = left;
	}
	
	public void setRightChild(Node right){
		this.right = right;
	}
}

class BinaryTree{
	Node root;
	
	public Node getRoot(){
		return this.root;
	}
	
	public boolean isEmpty(){
		return root == null ? true : false;
	}
	
	public boolean insert(int data){

		if(isEmpty()){
			Node head = new Node(data);
			this.root = head;
			return true;
		}
		
		Node curr = root;
		while(curr != null){
			Node leftChild = curr.getLeftChild();
			Node rightChild = curr.getRightChild();
			if(data < curr.getData()){
				if(leftChild == null){
					leftChild = new Node(data);
					curr.setLeftChild(leftChild);
					return true;
				}
				curr = leftChild;
			}
			else if(data > curr.getData()){
				if(rightChild == null){
					rightChild = new Node(data);
					curr.setRightChild(rightChild);
					return true;
				}
				curr = rightChild;
			}
		}
		
		return false;
	}
	
	public Node search(int value){
		Node current = root;
		
		while(current != null){
			if(current.getData() == value)
				return current;
			
			if(value < current.getData()){
				// value less than current data 
				current = current.getLeftChild();
			}else{
				current = current.getRightChild();
			}
		}
		
		return null;
	}
	
	public void delete(int value){
		if(root == null)
			return;
		
		Node parent = null;
		Node current = root;
		Node searched = null; 
		
		while(current != null){
			if(current.getData() == value){
				searched = current;
				break;
			}
			if(value < current.getData()){
				// value less than current data 
				parent = current;
				current = current.getLeftChild();
			}else{
				parent = current;
				current = current.getRightChild();
			}
		}
		System.out.println("Parent: "+parent.getData());

		// Case 1
		if(current.getLeftChild() == null && current.getRightChild() == null){
			if(parent.getRightChild().getData() == value)
				parent.setRightChild(null);
			else if(parent.getLeftChild().getData() == value)
				parent.setLeftChild(null);
			return;
		}
		
		//  Case 2 
		if(current.getLeftChild() == null || current.getRightChild() == null){
			if(current.getRightChild() != null){
				parent.setRightChild(current.getRightChild());
			}	
			if(current.getLeftChild() != null){
				parent.setLeftChild(current.getLeftChild());
			}
			return;
		}
		
		// Case 3
		if(searched.getLeftChild() != null && searched.getRightChild() != null){
			current = searched.getRightChild();
			parent = searched;
			boolean isLeftMost = false;

			while(current.getLeftChild() != null){
				isLeftMost = true;
				parent = current;
				current = current.getLeftChild();
			}
			
			int temp = current.getData();
			current.setData(value);
			searched.setData(temp);
			
			System.out.println("Parent: "+parent.getData());
			System.out.println("Current: "+current.getData());
			
			if(isLeftMost){
				parent.setLeftChild(null);
			}
			else 
				parent.setRightChild(null);
						
		}	
		
		return;
	}
	
	public boolean recursive_helper(Node current, int data){
		if(current == null){
			current = new Node(data);
			return true;
		}
		
		Node leftChild = current.getLeftChild();
		Node rightChild = current.getRightChild();
		
		if(data < current.getData()){
			if(leftChild == null){
				leftChild = new Node(data);
				current.setLeftChild(leftChild);
				return true;
			}
			current = leftChild;
		}else if(data > current.getData()){
			if(rightChild == null){
				rightChild = new Node(data);
				current.setRightChild(rightChild);
				return true;
			}
			current = rightChild;
		}else{
			return true;
		}
		
		return recursive_helper(current, data);
	}
	
	public boolean recursive_insert(int data){
		return recursive_helper(this.root, data);
	}
	
	//Just for Testing purpose 
	public void printTree(Node current) 
    {
		if (current == null) 
			return;
		printTree(current.getLeftChild());
		System.out.print(current.getData() + ",");
		printTree(current.getRightChild());

	}
	
	public void preorder(){
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			Node curr = stack.pop();
			System.out.print(curr.getData()+"\t");
			if(curr.getRightChild() != null){
				stack.push(curr.getRightChild());
			}
			if(curr.getLeftChild() != null){
				stack.push(curr.getLeftChild());
			}
			
		}
	}
	
	public void inorder(){
		Stack<Node> stack = new Stack<>();
		Node curr = root;		
		while(curr != null || !stack.isEmpty()){
			while(curr != null){
				stack.push(curr);
				curr = curr.getLeftChild();
			}
			curr = stack.pop();
			System.out.print(curr.getData()+"\t");
			curr = curr.getRightChild();
		}
	}
	
	public void postorder(){
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		List<Integer> list = new ArrayList<>();
		while(!stack.isEmpty()){
			Node curr = stack.pop();
			list.add(0, curr.getData());
			if(curr.getLeftChild() != null){
				stack.push(curr.getLeftChild());
			}
			if(curr.getRightChild() != null){
				stack.push(curr.getRightChild());
			}			
		}
		
		for(int x: list)
			System.out.print(x+"\t");
	}
	
	public int findMin(){
		Node curr = root;
		while(curr.getLeftChild() != null){
			curr = curr.getLeftChild();
		}
		return curr.getData();
	}
	
	public int findKMax(int K){
		Stack<Node> stack = new Stack<>();
		Node curr = root;
		List<Integer> list = new ArrayList<>();
		while(curr != null || !stack.isEmpty()){
			while(curr != null){
				stack.push(curr);
				curr = curr.getLeftChild();
			}
			curr = stack.pop();
			list.add(curr.getData());
			curr = curr.getRightChild();
		}
		
		return list.get(list.size()-K);
	}
	
	public List<Integer> findAncestors(int value){
		List<Integer> list = new ArrayList<>();
		Node curr = root;
		
		while(curr != null){
			if(curr.getData() == value)
				return list;	
			
			if(value < curr.getData()){
				list.add(curr.getData());
				curr = curr.getLeftChild();
			}
			else{
				list.add(curr.getData());
				curr = curr.getRightChild();
			}
		}
		
		return null;
	}
}

public class BST {
	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		bst.insert(6);
		bst.insert(9);
		bst.insert(4);
		bst.insert(5);
		bst.insert(2);
		bst.insert(8);
		bst.insert(7);
		//bst.recursive_insert(6);
		//bst.recursive_insert(4);
		//bst.recursive_insert(7);
		bst.printTree(bst.getRoot());
		System.out.println("\nSearch 40: "+bst.search(40));
		System.out.println("\nSearch 20: "+bst.search(20));
		System.out.println("\nSearch 100: "+bst.search(100));
		//bst.delete(2);
		//bst.printTree(bst.getRoot());
		//bst.delete(3);
		//bst.printTree(bst.getRoot());
		//bst.delete(6);
		bst.printTree(bst.getRoot());
		System.out.println();
		bst.preorder();
		System.out.println();
		bst.inorder();
		System.out.println();
		bst.postorder();
		System.out.println("Min element: "+bst.findMin());
		System.out.println("Kth maximum element: "+bst.findKMax(4));
		List<Integer> ancestors = bst.findAncestors(3);
		System.out.println("Ancestors of 7: ");
		for(int x: ancestors)
			System.out.print(x+"\t");
	}
}