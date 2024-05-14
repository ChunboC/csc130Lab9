package lab9;

public class Lab9App {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		int[] arr = {6, 11, 9, 7, 4, 5, 10, 2, 19, 28, 1};
		for (int i : arr) 
			bst.insert(i);
		bst.preOrder();
		bst.inOrder();
		bst.postOrder();
		bst.levelOrderPrint();
		System.out.println("\nHeight: " + "\n" + bst.height());
		buildHeap(arr, 11);
		System.out.println("\nMax Heap: ");
		for (int n : arr)
			System.out.print(n + " ");
	}
	
	public static void buildHeap(int[] a,int size) {
		// start from last parent to first parent
		for(int i = size / 2 - 1; i >= 0; i--)
		heapify(a,i,size);
	}
	
	public static void heapify(int[] a, int i, int size) {
		int l = 2 * i + 1; // left child
		int r = 2 * i + 2; // right child
		int largest=i; // parent
		// find the larger of parent and left child
		if(l <= size-1 && a[l] > a[i])
			largest = l;
		else
			largest = i;
			// find the larger of parent and right child
		if(r <= size-1 && a[r] > a[largest])
			largest = r;
			// swap parent and larger child if necessary
		if(largest != i) {
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			// repeat heapify until all children are in a heap
			heapify(a, largest, size);
		}
	}
	
}
