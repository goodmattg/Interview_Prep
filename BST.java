import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;


public class BST {

	public static int search(int[] int_arr, int key) {
	int low = 0;
	int high = (int_arr.length-1); 
	int mid = low + (high-low)/2;
	
	while (int_arr[mid]!=key) {
		if (int_arr[mid] > key) {
			high = mid - 1; 	
		}
		else {
			low = mid + 1; 
		}
		mid = (low + high)/2; 
	}
	System.out.println(mid); 
	return mid;
	}
	
	// Algorithm to find a pair of numbers in a BST that add to input, O(N) time O(height) space
	public static void outputSumPair(Tree t, int find) {
		Deque<Integer> lessThan = new ArrayDeque<Integer>();
		Deque<Integer> greaterThan = new ArrayDeque<Integer>();
		
		
		
		// The less than stack is the lefthand branch all the way down
		// The righthand branch is 

	
	}
	
	public static void main(String[] args) {

		int[] myarr = {1,2,3,4,5,7,8,9} ; 
		BST.search(myarr, 3);
	}

}
