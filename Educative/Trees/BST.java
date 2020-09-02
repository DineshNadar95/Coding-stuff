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
	
	public Node getLeftChild(){
		return left;
	}
	
	public Node getRightChild(){
		return right;
	}
	
	public void setData(int data){
		this.data = data;
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
}

public class BST {
	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		bst.insert(60);
		bst.insert(20);
		bst.insert(40);
		bst.recursive_insert(10);
		bst.recursive_insert(50);
		bst.printTree(bst.getRoot());
	}
}