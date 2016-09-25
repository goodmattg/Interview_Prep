import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MapTests {

Map<Integer,Set<Integer>> hm = new HashMap<Integer,Set<Integer>>();
	int[] cats = new int[10];
	String s = "cats";
	Deque<Double> dq = new ArrayDeque<Double>();
	double[] sorted = dq.stream().sorted((v1, v2) -> v1.compareTo(v2)).mapToDouble(i -> i.doubleValue()).toArray();
	
}
