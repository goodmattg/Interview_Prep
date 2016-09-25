import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class arrayStuff {
	
	public static int[] findSubArr(int[] complete, int target) {
	    
	    int i = 0;
	    int j = 0;
	    int sum = 0;

	    while (j <= i && i < complete.length) {
	        if (sum == target) {
	            return Arrays.copyOfRange(complete, j, i);
	        } else if (sum < target) {
	            sum += complete[i];
	            i++;
	        } else if (sum > target) {
	            sum -= complete[j];
	            j++;
	        }
	    }
	    return null;
	}


	public static void main(String[] args) {
		int[] test = {1,4,3,5,2,9,8};
		int[] ret = findSubArr(test, 19);
		System.out.println(Arrays.toString(ret));
		List<Integer> a = new ArrayList<Integer>();

	}

}
