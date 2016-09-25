public class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public static void reverse_linked_list(Node head) {

		Node prev, curr, next; 
		prev = null; 
		next = null;
		curr = head; 
		
		while (curr != null){
			next = curr.next; 
			curr.next = prev; 
			prev = curr;
			curr = next; 
		}

	}
	
	public void return_head() {
		System.out.println(data);
	}
}