public class MergeSort {
	Node head;
	Node tail;
	
	public MergeSort() {
		head = null;
		tail = null;
	}
	
	public void append(String item) {
		Node newNode  = new Node(item);
		if(isEmpty()) head = tail = newNode;
		else tail = tail.next = newNode;
	}
	
	public void sort() {
		if(!isEmpty()) {
			tail = head = doMergeSort(head);
			while(tail.next != null) tail = tail.next;
		}
	}
	
	public Node doMergeSort(Node newHead) {
		if(newHead == null || newHead.next == null) return newHead;
		Node middle = getMiddle(newHead);
		Node nextOfMiddle = middle.next;
		middle.next = null;
		return sortedMerge(doMergeSort(newHead), doMergeSort(nextOfMiddle));
	}

	private Node sortedMerge(Node left, Node right) {
		if(left == null) return right;
		if(right == null) return left;
		Node newHead = null;
		if(left.item.compareTo(right.item) < 0) {
			newHead = left;
			newHead.next = sortedMerge(left.next, right);
		} else {
			newHead = right;
			newHead.next = sortedMerge(left, right.next);
		}
		return newHead;
	}

	private Node getMiddle(Node newHead) {
		if(newHead == null) return newHead;
		Node slow, fast = slow = newHead;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public String toString() {
		return head != null ? head.toString() : "null" ;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to merge sort program");
		MergeSort mergeSort = new MergeSort();
		mergeSort.append("Rakesh");
		mergeSort.append("Kamal");
		mergeSort.append("Durgesh");
		mergeSort.append("Mithesh");
		mergeSort.append("Hetal");
		mergeSort.append("Pushpak");
		System.out.println("Before sorting");
		System.out.println(mergeSort);
		mergeSort.sort();
		System.out.println("After sorting");
		System.out.println(mergeSort);
		mergeSort.append("Babita");
		System.out.println("Append Babita after sorting");
		System.out.println(mergeSort);
	}

}
