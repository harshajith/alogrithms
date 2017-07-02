package test.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Harsha on 4/2/17.
 * if a string is aaabb1133344 if it is a digit, it should return sum, otherwise count no of chars
 */
public class SCB {

    public static void main(String[] args){
        String str = "aabb33223322";
        char[] array = str.toCharArray();
        Map<String, Integer> map = new HashMap<String, Integer>();

        List<Integer> x = new ArrayList<Integer>();
        x.set(1,4343);

        System.out.println(x.get(1));


        for(int i=0; i<array.length;i++){

            if(map.get(String.valueOf(array[i])) != null){

                if(Character.isDigit(array[i])){
                    Integer num = map.get(String.valueOf(array[i]));
                    num = num + Integer.valueOf(array[i]);
                }else {
                    Integer num = map.get(String.valueOf(array[i]));
                    num = num + 1;
                }
            }else {
                if(Character.isDigit(array[i])){
                    map.put(String.valueOf(array[i]), Integer.valueOf(array[i]));
                }else {
                    map.put(String.valueOf(array[i]), 1);
                }

            }

        }

        System.out.println(map.toString());


    }
}
