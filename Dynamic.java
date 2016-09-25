
public class Dynamic {

	public static int max_coin(int[] coin, int start, int end){
		if (start > end) {
			return 0;
		}
		
		// From either side calculate the recursive strategy. 
		
		int a = coin[start] + Math.min( max_coin( coin, start+2,end ), max_coin( coin, start+1,end-1 ) );
		int b = coin[end] + Math.min( max_coin( coin, start+1,end-1 ), max_coin( coin, start,end-2 ) );
		
		return Math.max(a,b);
	}
	
	public static double islandSurvive(int x, int y, int N, int steps) {
		double survs = (double) islandHelp(x,y,N,steps);
		return survs / Math.pow(4.0, (double) steps);
	}
	
	public static int islandHelp(int x, int y, int N, int rem) {
		if (x > N-1 || x < 0 || y < 0 || y > N-1) {
			return 0;
		}
		if (rem == 0) { return 1; }
		else {
			return islandHelp(x+1,y,N,rem-1) + 
				   islandHelp(x-1,y,N,rem-1) + 
				   islandHelp(x,y-1,N,rem-1) + 
				   islandHelp(x,y+1,N,rem-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(islandSurvive(3,1,4,2));
	}
}
