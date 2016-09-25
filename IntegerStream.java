import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;


public class IntegerStream {
	
	PriorityQueue<Integer> left;
	PriorityQueue<Integer> right;
	int median;
	
	public IntegerStream() {
		right = new PriorityQueue<Integer>();
		left = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		median = 0;
	}
	
	public void addToSet(int el) {
		if (el <= median) {
			left.add(el);
		}
		else {
			right.add(el);
		}
		balance();
		median = currentMedian();
		System.out.print(median);
		
		Deque<Double> dq = new ArrayDeque<Double>();
		dq.stream().mapToDouble(i -> i.doubleValue()).sum();
	}
	
	public int currentMedian() {
		if (left.size() == right.size()) {
			return (left.peek() + right.peek()) / 2;
		} else if (left.size() > right.size()) {
			return left.peek();
		} else {
			return right.peek(); 
		}
	}
	
	// balance heaps
	public void balance() {
		if (Math.abs(left.size()-right.size()) > 1) {
			if (left.size() > right.size()) {
				right.add(left.poll());
			} else {
				left.add(right.poll());
			}
		}
	}
	
	
}
