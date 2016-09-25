import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    
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
    
    
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Map<String, List<List<String>>> hm = new HashMap<String, List<List<String>>>();
        
        List<String> input = new ArrayList<String>();
        input.add("user1 L1,L2,L3");
        input.add("user2 L4,L5,L4");
//        input.add("user3 L3,L5,L4");
//        input.add("user4 L1,L5,L7");
//        input.add("user5 L3,L2,L7");
        
        // Build the data structure 
        for (String str : input) {
            String line = str;
            String[] comps = line.split(" ");
            String path_id = comps[0];
            String[] locks = comps[1].split(",");
            
            for (int t = 0 ; t < locks.length ; t++) {
                
                String lk = locks[t];
                
                List<List<String>> prev_path_set = hm.get(lk);
                
                if (prev_path_set == null) {
                    // Lock not yet established in data structure
                    List<List<String>> path_set = new ArrayList<List<String>>();
                    for (int n = 0 ; n < locks.length ; n++) { path_set.add(null); }
                    List<String> paths_at_time = new ArrayList<String>();
                    
                    paths_at_time.add(path_id);
                    path_set.set(t, paths_at_time);                    
                    hm.put(lk, path_set);
                 
                } else if (prev_path_set.get(t) == null) {
                    // Lock established, time path set not established
                    List<String> paths_at_time = new ArrayList<String>();
                    paths_at_time.add(path_id);
                    prev_path_set.set(t, paths_at_time);
                    hm.put(lk, prev_path_set);         
                    
                } else {
                    // Lock and time path set established - add to time path set
                    List<String> paths_at_time = prev_path_set.get(t);
                    paths_at_time.add(path_id);
                    prev_path_set.set(t, paths_at_time);
                    hm.put(lk, prev_path_set);
                }
            }    
        }
        
        // The complete set of conflicting paths
        Set<Set<String>> total_conflict_set = new HashSet<Set<String>>();
        
        // Iterate over each lock set to produce power set of conflicting paths
        for (String lock: hm.keySet()) {
            
            List<List<String>> path_set = hm.get(lock);
            
            for (List<String> path_times_set : path_set) {
                if (path_times_set == null) { continue; }
                if (path_times_set.size() < 2) { continue; }
                total_conflict_set.addAll(powerSet(path_times_set));
           }
        }
        
        Set<String> internal_sorted = new HashSet<String>();
        for (Set<String> set : total_conflict_set) {
        	List<String> l = new ArrayList<String>(set);
        	Collections.sort(l);
        	// TO A STRING REPRESENTATION
            internal_sorted.add(l.toString());
        }
        
        List<String> complete_sorted = new ArrayList<String>(internal_sorted);
        Collections.sort(complete_sorted);
        
        for (String str : complete_sorted) {
        	System.out.println(str.replaceAll("\\s|\\]|\\[", ""));
        }
        // Sort and display all path sets 
        
    }
}