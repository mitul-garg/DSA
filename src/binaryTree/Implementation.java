package binaryTree;

import java.util.Stack;

public class Implementation {

	public static void main(String[] args) {
		Node root = new Node(10); // or to create an empty tree -> Node root = null; 
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.left = new Node(60);
		root.right.right = new Node(70);
		
		inorder(root);
		System.out.println();
		
		preorder(root);
		System.out.println();
		
		postorder(root);
		System.out.println();
		
		System.out.println("Size : " + sizeOfBT(root));
		
		System.out.println("Maximum Value : " + maxOfBT(root));
		
		System.out.println("Height : " + heightOfBT(root));
		
		iterativeInorder(root);
		
		iterativePreorder(root);
	}
	
	static void iterativePreorder (Node root) {
		// Time Complexity O(n) and Auxiliary Space O(h)
		Stack<Node> s = new Stack<Node>();
		Node curr = root;
		while (curr!=null || s.isEmpty()==false) {
			while (curr!=null) {
				System.out.print(curr.key + " ");
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			curr=curr.right;
		}
		System.out.println();
	}
	
	static void iterativeInorder (Node root) {
		// Time Complexity O(n) and Auxiliary Space O(h)
		Stack<Node> s = new Stack<Node>();
		Node curr = root;
		while ((curr!=null) || (s.isEmpty()==false)) {
			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.print(curr.key + " ");
			curr = curr.right;
		}
		System.out.println();
	}
	
	static int heightOfBT (Node root) {
		// Time Complexity is O(n), Auxiliary Space is O(h)
		if (root == null) 
			return 0;
		else {
			return Math.max(1 + heightOfBT(root.right), 1 + heightOfBT(root.left));
		}
	}
	
	static int maxOfBT (Node root) {
		// Time Complexity is O(n), Auxiliary Space is O(h)
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		else {
			return Math.max(root.key, Math.max(maxOfBT(root.left), maxOfBT(root.right)));
		}
	}
	
	static int sizeOfBT (Node root) {
		// Time Complexity is O(n), Auxiliary Space is O(h)
		if (root != null) {
			return 1 + sizeOfBT(root.left) + sizeOfBT(root.right);
		}
		else {
			return 0;
		}
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