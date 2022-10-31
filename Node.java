public class Node <Type>{
	Type item;
	Node next;
	
	public Node(Type item) {
		this.item = item;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return "[ "+item+(next != null ? " -> "+next : "" )+" ]";
	}
}
