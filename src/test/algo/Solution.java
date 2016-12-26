package test.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	
	
	
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        
        Map<Integer, Integer> batch = new HashMap<Integer, Integer>();
        int weight = 0;
        int capacity = 0;
        int totalStops = 0;
        
        
        for(int i=0;i<A.length;i++){
            
        	boolean batchReady = false;
            capacity++;
            weight += A[i];
            batch.put(i, B[i]); // put the person and floor no 
            
            if((weight > Y) || (capacity > X)){ // get the max batch size
                batch.remove(i); // remove the last addition as it crosses either capacity limit or weight limit
                batchReady = true;
                totalStops += processBatch(batch); // figure out unique floors
            	capacity = 1;
                weight = B[i];
                batch.clear();
                batch.put(i, B[i]);
            }
            
            if(i == A.length-1){
            	if((weight > 0 && weight < Y) || (capacity>0 && capacity < X)){
            		totalStops += processBatch(batch); // last run
            	}
        		
        	}
        }
        
        return totalStops;
        
        
    }
    
    private int processBatch(Map<Integer, Integer> batch) {
        if(!batch.isEmpty()){
        	
        	Set<Integer> set = new HashSet<Integer>(batch.values());
        	int stops  = set.size();
        	
        	return stops +1; // return the total stops per batch, it includes coming back to the ground as well.
            
        }
        return 0;
        
        
    }
    
    
    public static void main(String[] args) {
    	
    	int[] A = new int[3];
    	int[] B = new int[3];
    	A[0] = 60;    B[0] = 2;
    		    A[1] = 80 ;   B[1] = 3;
    		    A[2] = 40   ; B[2] = 5;
		Solution s = new Solution();
				System.out.println(s.solution(A, B, 5, 2, 200));

	}
}
