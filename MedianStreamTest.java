import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;


public class MedianStreamTest {

    // Helper function: powerset (of size >= 2) given list of strings  
    public static Set<Set<String>> powerSet(List<String> list) {
        
        Set<Set<String>> ret = new HashSet<Set<String>>();
        
        for (int i = 0 ; i < list.size() ; i++) {
          
          HashSet<HashSet<String>> tmp_copy = new HashSet<HashSet<String>>();  
            // copy existing sets
            for (Set<String> s : ret) {
                tmp_copy.add(new HashSet<String>(s));
            } 
            // add new element to existing sets
            for (Set<String> s  : tmp_copy) {
                s.add(list.get(i));
            }
            // add current element as individual sets
            HashSet<String> solo = new HashSet<String>();
            solo.add(list.get(i));
            tmp_copy.add(solo);
            ret.addAll(tmp_copy);   
        }
        
        // Filter power set to only include sets of size >= 2
        Set<Set<String>> remSet = new HashSet<Set<String>>();
        for (Set<String> hs : ret) {
            if (hs.size() == 1 ) { remSet.add(hs); }
        }
        ret.removeAll(remSet);
        return ret; 
    } 
   
	
	@Test
	public void secondTest() {
		
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("dog");
		list.add("boy");
		list.add("carlos");
		
		Set<Set<String>> pset = powerSet(list);
		
		Iterator iter = pset.iterator();
		while (iter.hasNext()) {
		    System.out.println(iter.next());
		}




		

	}

}
