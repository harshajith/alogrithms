package test.algo;

public class SequenceChecker{

    private static int[] A = new int[]{23, 5, 4, 11};
    private static int T = 20;
    private static int total = 0;
    
    
    public static void main(String[] args){
       System.out.println("Given sequence has a continues sequence : " + checkForContinuesSequence(0, T));
    
    }
    
    public static boolean checkForContinuesSequence(int startIndex, int T){
    
       if(startIndex > A.length-1){
           return false;
       }
    
       int start = A[startIndex];
       if(start == T){ 
           return true;
       }else if(start > T){
           return checkForContinuesSequence(startIndex+1, T);
       }else {
         total += start;
         if(total == T){
            return true;
         }else if(total < T){
            return checkForContinuesSequence(startIndex+1, T);
         }else { // if total > T, continue the operation setting current element as the start
             total = start;
             return checkForContinuesSequence(startIndex+1, T);
         }
       }
    }
}