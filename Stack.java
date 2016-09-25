public class Stack {
	Node front;
	private int min; 

	public Stack(int val) {
		this.front = new Node(val);
		this.min = val; 
	}

	public void push(int val) {

		if (front == null) {
			front = new Node(val);
		} else {
			Node n = new Node(val);
			n.next = front;
			front = n;
		}
	}

	public int top() {
		return front.data;
	}
	
	public int pop() {
		if (front == null) {
		System.out.println(-1);
		 return -1;
		}
		else if (front.next == null) {
			int dat = front.data; 
			front = null; 
			System.out.println(dat); 
			return dat; 
		}
		else {
			int dat = front.data; 
			front = front.next; 
			System.out.println(dat); 
			return dat; 
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node st = new Node(5);
		st.appendToTail(4);
		st.appendToTail(3);
		st.appendToTail(2);
		st.appendToTail(1);
		Node.reverse_linked_list(st);
		st.return_head(); 
	}

}
