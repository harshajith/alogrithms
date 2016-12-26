package test.algo;

public class FindIfAllCharsUnique {

	
	/**
	 * Runnit time is O(n), if string is length n, we need to max iterate n times.
	 * @param s
	 * @return
	 */
	public boolean checkIfAllCharsUnique(String s){
		
		if(s != null && !s.isEmpty()){
			boolean[] result = new boolean[256]; // assuming chars are ASCHII
			for(int i=0; i< s.length(); i++){
			  char x = s.charAt(i);
			  if(result[x]){
				  return false;
			  }
			  result[x] = true;
			}	
		}
		return true;
		
	}
	
	
	public static void main(String[] args) {
		String a = new String("abc");
		FindIfAllCharsUnique obj = new FindIfAllCharsUnique();
		System.out.println(obj.checkIfAllCharsUnique(a));
		
		// TODO Auto-generated method stub

	}

}
