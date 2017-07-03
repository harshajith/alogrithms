package nalin.challenge.treechallenge;

import java.util.Stack;

/**
 * DFS to find out visible nodes
 * CONDITION == nodes are visible if values are higher than the root value
 * Created by Harsha on 2/7/17.
 */
public class Solution {

    public int solution(Tree t){
        Stack<Tree> stack = new Stack();
        int count = 0;
        int rootValue = t.X;
        stack.push(t);

        while(!stack.isEmpty()){
            Tree current = stack.pop();
            if(count == 0) {
                count++; // root node
            }else {
                if(current.X >= rootValue){
                    count++;
                }
            }
            if(current.r != null){
                stack.push(current.r);
            }

            if(current.l != null){
                stack.push(current.l);
            }
        }
        return count;
    }


    public static void main(String[] args){
        Solution s = new Solution();
        int visibleNodes = s.solution(s.makeTree());
        System.out.println(visibleNodes);
    }


    public Tree makeTree(){
        Tree t1 = new Tree(5);
        Tree t2 = new Tree(3);
        Tree t3 = new Tree(20);
        Tree t4 = new Tree(21);
        Tree t5 = new Tree(10);
        Tree t6 = new Tree(1);
        Tree t7 = new Tree(2);

        t2.l = t3;
        t2.r = t4;
        t5.l = t6;
        t5.r = t7;
        t1.l = t2;
        t1.r = t5;

        return t1;
    }

}
