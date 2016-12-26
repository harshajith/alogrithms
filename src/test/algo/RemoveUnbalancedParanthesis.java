package test.algo;

public class RemoveUnbalancedParanthesis {

	public static void main(String[] args) {
		String original = "(sdfdsfs))sdfs(dfss(sdfds)SFSF)dsfs)a)";
		System.out.println(balance(original));
	}

	private static String balance(String original) {
		
		
		char[] chars = original.toCharArray();
		int count = 0;
		
		for(int i=0;i<original.length();i++){
			if(String.valueOf(chars[i]).equals("(")){
				count ++;
			}else if(String.valueOf(chars[i]).equals(")")){
				if(count > 0){
					count--;
				}else {
					original = original.substring(0,i) + original.substring(i+1,original.length()); // removed access ) characters
				}
			}else {
				continue;
			}
		}
		
		int count2 = 0;
		for(int j=original.length()-1;j>=0;j--){
			if(String.valueOf(chars[j]).equals(")")){
				count2 ++;
			}else if(String.valueOf(chars[j]).equals("(")){
				if(count2 > 0){
					count2 --;
				}else {
					original = original.substring(0, j) + original.substring(j+1, original.length());
				}
			}else {
				continue;
			}
		}
		
		return original;
	}

}
