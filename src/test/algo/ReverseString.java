package test.algo;

public class ReverseString {
	 
	public ReverseString(String a){
		
		int l = a.length() - 1;
		char[] result = new char[a.length()];
		for(int i=0; i < a.length() ; i++){
			result[i] = a.charAt(l-i);
			System.out.println(result[i]);
		}
		System.out.println(String.valueOf(result));
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ReverseString("werwtwettcwfse");
	}

}
