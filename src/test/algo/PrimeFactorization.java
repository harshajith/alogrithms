package test.algo;

/**
 * Created by Harsha on 13/5/17.
 */
public class PrimeFactorization {




    public void printPrimeNumbers(int val){


        for(int i=3; i*i<val; i += 2){
            if(val%i == 0){
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args){
        PrimeFactorization pf = new PrimeFactorization();
        pf.printPrimeNumbers(80);
    }


}
