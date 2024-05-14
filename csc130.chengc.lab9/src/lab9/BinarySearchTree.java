package lab9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * Title: BinarySearchTree.java
 * </p>
 *
 * <p>
 * Description: This class provides the basic functionalities of a binary search tree, including insertion,
 * computation of the tree height, and traversal operations (pre-order, in-order, post-order,
 * and level-order).
 * </p>
 *
 * @author Chunbo Cheng
 */

public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * A nested class representing a node in the BST.
	 *
	 * @param <E> the type of element contained in the node, which must be
	 *            Comparable
	 */
	class BinaryNode<E extends Comparable<E>> {
		protected E data;
		protected BinaryNode<E> left, right;

		/**
		 * Constructs a new node with the specified data.
		 *
		 * @param d the data to be stored in the node
		 */
		BinaryNode(E d) {
			data = d;
			left = right = null;
		}

		/**
		 * Returns a string representation of the node.
		 *
		 * @return the string representation of the node data
		 */
		public String toString() {
			return "" + data;
		}
	}

	private BinaryNode<T> root;

	/**
	 * Inserts the specified element into the BST.
	 *
	 * @param d the element to be inserted
	 */
	public void insert(T d) {
		root = insert(d, root);
	}

	/**
	 * Returns the height of the BST.
	 *
	 * @return the height of the BST, or -1 if the tree is empty
	 */
	public int height() {
		return height(root);
	}

	/**
	 * Prints the elements of the BST in pre-order traversal.
	 */
	public void preOrder() {
		System.out.println("\nPreorder:");
		preOrder(root);
	}

	/**
	 * Prints the elements of the BST in in-order traversal.
	 */
	public void inOrder() {
		System.out.println("\nInorder:");
		inOrder(root);
	}

	/**
	 * Prints the elements of the BST in post-order traversal.
	 */
	public void postOrder() {
		System.out.println("\nPostorder:");
		postOrder(root);
	}

	/**
	 * Prints the elements of the BST in level-order traversal.
	 */
	public void levelOrderPrint() {
		System.out.println("\nLevelorder:");
		levelOrderPrint(root);
	}

	/**
	 * Inserts the specified element into the BST at the given node.
	 *
	 * @param d    the element to be inserted
	 * @param root the root of the subtree where the element is to be inserted
	 * @return the new root of the subtree
	 */
	private BinaryNode<T> insert(T d, BinaryNode<T> root) {
		if (root == null)
			root = new BinaryNode<T>(d);
		else if (root.data.compareTo(d) > 0)
			root.left = insert(d, root.left);
		else
			root.right = insert(d, root.right);
		return root;
	}

	/**
	 * Returns the height of the subtree rooted at the specified node.
	 *
	 * @param node the root of the subtree
	 * @return the height of the subtree, or -1 if the node is null
	 */
	private int height(BinaryNode<T> node) {
		if (node == null)
			return -1;
		return (Math.max(height(node.left), height(node.right)) + 1);
	}

	/**
	 * Performs pre-order traversal of the subtree rooted at the specified node.
	 *
	 * @param root the root of the subtree
	 */
	private void preOrder(BinaryNode<T> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	/**
	 * Performs in-order traversal of the subtree rooted at the specified node.
	 *
	 * @param root the root of the subtree
	 */
	private void inOrder(BinaryNode<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	/**
	 * Performs post-order traversal of the subtree rooted at the specified node.
	 *
	 * @param root the root of the subtree
	 */
	private void postOrder(BinaryNode<T> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	/**
	 * Performs level-order traversal of the subtree rooted at the specified node.
	 *
	 * @param root the root of the subtree
	 */
	private void levelOrderPrint(BinaryNode<T> root) {
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		LinkedList<BinaryNode<T>> list = new LinkedList<BinaryNode<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode<T> item = queue.remove();
			if (item != null) {
				list.add(item);
				if (item.left != null)
					queue.add(item.left);
				if (item.right != null)
					queue.add(item.right);
			}
		}
		System.out.println(list);
	}

}