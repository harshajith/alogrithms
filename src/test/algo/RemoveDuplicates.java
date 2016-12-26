package test.algo;

public class RemoveDuplicates {

	
	public static void removeDuplicates(char[] str) {
		 if (str == null) return;
		 int len = str.length; 
		 if (len < 2) return; // no duplicates
		
		 int tail = 1;
		 
		 for(int i=0; i< len; i++){
			 int j;
			 for(j=0; j< tail; ++j){
				 if(str[i] == str[j]) break;
			 }
			 
			 if(j==tail){
				 str[tail] = str[i];
				 System.out.println("adding : " + str[tail]);
				 tail++;
			 } 
		 }
		 str[tail] = 0;
		 
		 System.out.println(String.valueOf(str));
		 

	}



	public static void main(String[] args) {
		RemoveDuplicates.removeDuplicates("abcd".toCharArray());

	}

}
