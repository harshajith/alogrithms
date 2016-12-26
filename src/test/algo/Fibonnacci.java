package test.algo;

public class Fibonnacci {
	
	
	public long getFibonacci(int n){
		
		System.out.println(n);
		if(n == 0) return 0;
		if(n==1) return 1;
		
		return getFibonacci(n-1) + getFibonacci(n-2);
		
	}
	
	
	
	
	public static void main(String[] args){
		Fibonnacci fb = new Fibonnacci();
		System.out.println(fb.getFibonacci(4));
	}

}
