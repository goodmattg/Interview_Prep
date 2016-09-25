import java.util.HashSet;
import java.util.Set;


public class ValidParenSets {

	// Prints all valid parent sets of length 2*N
	public static void validParenSets(int N) {
		parenHelper(N,N,"");
	}
	
	public static void parenHelper(int left, int right,String string) {
	    if(left == 0 && right == 0) 
	        System.out.println(string);
	    if(left>right)
	        return;
	    if (left > 0)
	        parenHelper(left-1,right,string+"(");
	    if (right > 0) 
	        parenHelper(left,right-1,string+")");

	}
	
	public static void main(String[] args) {
		validParenSets(3);
	}
	
}
