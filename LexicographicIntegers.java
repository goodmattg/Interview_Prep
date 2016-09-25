
public class LexicographicIntegers {
	
	public static void printLexico(int N) {
		int cur = 1;
		int ct = 1;
		System.out.println(cur);
		
		while (ct < N) {
			while (cur * 10 < N) {
				if (ct > N) { break; }
				cur = cur * 10;
				System.out.println(cur); ct++; 
			}
			while ((cur+1) % 10 > 0 && (cur+1) < N) {
				if (ct > N) { break; }
				cur++;
				System.out.println(cur); ct++; 
			}
			cur++;
			while (cur % 10 == 0) {
				if (ct > N) { break; }
				cur = cur / 10;
			}
			System.out.println(cur); ct++; 
		}
	}

	public static void main(String[] args) {
		printLexico(1001);
	}

}
