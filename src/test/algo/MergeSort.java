package test.algo;

import java.util.Random;

public class MergeSort {

	
	public void merge(int[] input){
		
		int length = input.length;
		int halfSize = length / 2;
		int[] A = new int[halfSize];
		int[] B = new int[halfSize];
		for(int i=0; i<halfSize; i++){
			A[i] = input[i];
		}
		for(int j=halfSize; j<length; j++){
			B[j] = input[j];
		}
		
		mergeTst(A, B);
		
		
	}
	
	private void mergeTst(int[] a, int[] b) { //sorted two arrays
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random x = new Random();
		//x.nextIn

		int[] input = new int[]{2,44,4,43,64,63,3,5,6,33};
		
	}

}
