package nalin.challenge.treechallenge;

/**
 * Created by Harsha on 2/7/17.
 */
public class Tree {
    public int X;
    public Tree l;
    public Tree r;

    public Tree(int x){
        X = x;
        this.l = null;
        this.r = null;
    }
}
