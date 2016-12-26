package test.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileRead {
	
	private static BigDecimal total = new BigDecimal(0);

	public static void main(String[] args) {

		FileRead ci = new FileRead();
		BufferedReader br = null;

		try {

			String sCurrentLine;
			StringBuilder sb = new StringBuilder();
			Long[] inputArray = new Long[100000];

			br = new BufferedReader(new FileReader("/Users/Harsha/Documents/Coursera/algo/ReadFile.txt"));

			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				sb.append(sCurrentLine + ",");
				inputArray[i] =  (Long.valueOf(sCurrentLine));
				i++;
			}
			
			System.out.println(sb.toString());
			
			Long[] sortedArray = ci.divideAndConquer(inputArray);
		    System.out.println("Number of inversions: " + total);
			
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	
	public Long[] divideAndConquer(Long[] inputArray) {
	    int n = inputArray.length;
	    if(n == 1) {
	      return inputArray;
	    }
	    int mid = n/2;
	    Long[] leftArray = new Long[mid];
	    Long[] rightArray = new Long[n - mid];
	    System.arraycopy(inputArray, 0, leftArray, 0, leftArray.length);
	    System.arraycopy(inputArray, leftArray.length, rightArray, 0, rightArray.length);
	    divideAndConquer(leftArray);
	    divideAndConquer(rightArray);
	    merge(leftArray, rightArray, inputArray);
	    return inputArray;
	  }

	  public void merge(Long[] leftArray,Long[] rightArray,Long[] sortedArray) {
	    int leftArrayLength = leftArray.length;
	    int rightArrayLength = rightArray.length;
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    while(i < leftArrayLength && j < rightArrayLength) {
	      if(leftArray[i] < rightArray[j]) {
	        sortedArray[k] = leftArray[i];
	        i++;
	      } else {
	        sortedArray[k] = rightArray[j];
	        j++;
	        total = total.add(new BigDecimal(leftArray.length - i));
	      }
	      k++;
	    }
	    while(i < leftArrayLength) {
	      sortedArray[k] = leftArray[i];
	      i++;
	      k++;
	    }
	    while(j < rightArrayLength) {
	      sortedArray[k] = rightArray[j];
	      j++;
	      k++;
	    }
	  }
}
