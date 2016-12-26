package test.algo;
import java.util.List;
import java.util.ArrayList;

//TODO
public class HowManyValidLetters {
	
	public static void main(String[] args){
		
		
		String str = "21132ESF43";
		int size = 0;
		List<String> set = new ArrayList<String>();
		char[] chars  = str.toCharArray();
		String regex = "[1-9]+";
		for(char c: chars){
			boolean isNumber = String.valueOf(c).matches(regex);
			if(isNumber){
				addToFinalList(c);
				for(char k: chars){
					boolean number = String.valueOf(c).matches(regex);
					if(number && c != k){
						//int value = Integer.valueOf(i);
					}
				}
			}	
		}
	}

	private static void addToFinalList(char c) {
		// TODO Auto-generated method stub
		
	}

}
