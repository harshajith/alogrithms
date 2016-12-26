package test.algo;


import java.util.HashSet;
import java.util.Set;

public class FindPelindrome {

    public static void main(String[] args) {
        System.out.println(palindromeTest("harsha"));
    }

    public static boolean palindromeTest(String original) {
        Set palindromes = new HashSet();
        boolean canBePalindrome;

        String reverse = reverse(original);
        System.out.println("reverse :"+ reverse);
//        for(int i=original.length()-1;i>=0;i--){
//        	reverse = reverse + original.charAt(i);
//        }
        
        if(reverse.equals(original)){
        	return true;
        }else {
        	return false;
        }
        
        //return palindromes.size();
    }
    
    public static String reverse(String s){
    	
    	if(s.length()<= 0){
    		return "";
    	}
    	
    	return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
    }
}

