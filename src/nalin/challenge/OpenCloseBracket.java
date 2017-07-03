package nalin.challenge;

import java.util.Stack;

public class OpenCloseBracket {

    public static int solution(String s){
        Stack stack = new Stack();
        int count = 0;

        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);

            if(c != '(' && c != ')'){
                System.out.println("wrong input");
                return 0;
            }

            if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()){
                    stack.push(c);
                    count++;
                }else {
                    stack.pop();
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String s = "(())(((";
        System.out.println(solution(s));
    }
}
