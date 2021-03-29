package binaryTree;

public class Implementation {

	public static void main(String[] args) {
		Node root = new Node(10); // or to create an empty tree -> Node root = null; 
		root.left = new Node(20);
		root.right = new Node(30);
		root.right.left = new Node(40);
		root.right.right = new Node(50);
		
		inorder(root);
		System.out.println();
		
		preorder(root);
		System.out.println();
		
		postorder(root);
		System.out.println();
	}
	
	static void inorder (Node root) {
		//Time complexity is O(n), Auxiliary Space is O(h)
		if (root != null) { 
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}
	
	static void preorder (Node root) {
		//Time complexity is O(n), Auxiliary Space is O(h)
		if (root != null) {
			System.out.print(root.key + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	static void postorder (Node root) {
		//Time complexity is O(n), Auxiliary Space is O(h)
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.key + " ");
		}
	}
	
}
class Node {
	int key;
	Node right, left;
	Node(int key) {
		this.key = key;
	}
}