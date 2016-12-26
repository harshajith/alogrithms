package test.algo;

public class FindAnagram {
	
	public static void main(String[] args){
		String original = "CABCD";
		String searchStr = "DCC";
		
		boolean isAnagram = checkIfAnagram(original, searchStr);
		System.out.println(isAnagram);
	}
	
	public static boolean checkIfAnagram(String original, String searchStr){
		
		char[] chars = searchStr.toCharArray();
		for(char c : chars){
			int index = original.indexOf(c);
			if(index == -1){
				return false;
			}else {
				original = original.substring(0, index) + original.substring(index+1, original.length()); // remove the matching char from original string
			}
		}
		return true;
	}

}
