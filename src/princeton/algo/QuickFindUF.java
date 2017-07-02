package princeton.algo;

public class QuickFindUF {

	public static String reverseString(String str){
		if(str.length()< 1){
			return str;
		}
		return str.charAt(str.length()-1) + reverseString(str.substring(0, str.length()-1));
	}
	
	
	public static void main(String[] args) {
		System.out.println(reverseString("SSFDGSRGS"));
		System.out.println("TETTSFS".substring(0, 3));
	}

}
