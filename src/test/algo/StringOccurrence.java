package test.algo;

public class StringOccurrence {
	
	public StringOccurrence(){
		
	}
	
	public static void main(String[] args){
		String originalStr = "ABSCS";
		String strToFind = "CS";
		System.out.println("Result : " + checkIfStringPresent(originalStr, strToFind));
		
	}

	private static boolean checkIfStringPresent(String originalStr, String strToFind){
		
		if(originalStr != null){
			
			int index = originalStr.indexOf(strToFind);
			if(index != -1){
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}
}
