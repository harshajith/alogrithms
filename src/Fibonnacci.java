import java.util.Date;

/**
 * Created by Harsha on 6/10/16.
 */
public class Fibonnacci {

    public static void main(String[] args){
//        int n0=1;
//        int n1=1;
//
//        System.out.println(n0);
//        System.out.println(n1);
//        int n2=0;
//
//        do {
//            n2= n0 + n1;
//            System.out.println(n2);
//            n0 = n1;
//            n1= n2;
//        } while(n2<100);

        System.out.println("start time : " + new Date());
        for(int i=0; i<50;i++){
            System.out.println(fib(i));
        }
        System.out.println("end time : " + new Date());


    }




    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }

}
