/**
 * Created by Harsha on 6/10/16.
 */
public class Fibonnacci {

    public static void main(String[] args){


        int n0=0;
        int n1=1;

        int n2=0;

        while(n2 < 100){
            n2 = n0 + n1;
            System.out.println(n2);
            n0 = n1;
            n1 = n2;
        }



    }
}
