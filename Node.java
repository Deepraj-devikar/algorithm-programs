public class Node {
	String item;
	Node next;
	
	public Node(String item) {
		this.item = item;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return "[ "+item+(next != null ? " -> "+next : "" )+" ]";
	}
}
