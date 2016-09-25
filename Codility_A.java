// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Tree {
	public int x;
	public Tree r;
	public Tree l;
}

class Codility_A {
    public int solution(Tree T) {
        // write your code in Java SE 8
        // O(N) worst case time complexity indicates single iteration over the tree
        // Bottom-up, each node passes upwards the unique list of sets of integers it can produce
        // Return the length of the largest set 
        
        // Empty case
        if (T == null) { return 0; }
        // Non-empty case
        int retVal =0;
        Set<Set<Integer>> filterUp = findDistinct(T);
        
        // Grab the length of any returned set -> all have max distinct values
        for (Iterator<Set<Integer>> it = filterUp.iterator() ; it.hasNext();) {
            retVal = it.next().size();
            break;
        }
        return retVal;
    }
    
    public Set<Set<Integer>> findDistinct(Tree tr) {
        if (tr == null) { return new HashSet<Set<Integer>>(); }
        else {
            Set<Set<Integer>> lset = findDistinct(tr.l);
            Set<Set<Integer>> rset = findDistinct(tr.r);
            // Use lset as the complete set of sets
            int maxSize = 0;
            lset.addAll(rset);
            for (Set<Integer> set : lset) {
                set.add(tr.x);
                if (set.size() > maxSize) { maxSize = set.size(); }
            }
            final int msf = maxSize;
            // Filter set of sets to only contain the maximum set
            lset.stream().filter(i -> i.size() == msf);
            return lset;
        }
    
    }
}