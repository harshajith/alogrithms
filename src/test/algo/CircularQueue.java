package test.algo;

/**
 * Created by Harsha on 23/4/17.
 */
public class CircularQueue {

    private int front = -1;
    private int rear = -1;
    private int[] array = null;
    private int maxCapacity = 0;



    public CircularQueue(int capacity){
        maxCapacity = capacity;
        array = new int[capacity];

    }

    public int size(){
        if(rear > front){
            return rear - front;
        }
        return maxCapacity - front + rear;
    }

    public boolean isFull(){
        if((front == 0 && rear == maxCapacity-1) || (front == rear +1)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(){
        if(front == rear) return true;
        return false;
    }

    public void enqueue(int x){
        if(isFull()){
            throw new RuntimeException("Q is full");
        }
        array[rear] = x;
        rear = (rear + 1) % maxCapacity;
    }

    public int deQueue(){
        if(isEmpty()){
            throw new RuntimeException("Q is empty");
        }else {
            int val = array[front];
            array[front] = 0;
            front = front + 1;
            return val;
        }
    }

    public static void main(String[] args){
        CircularQueue queue = new CircularQueue(4);
        queue.enqueue(43);
        queue.enqueue(44);
        queue.enqueue(65);
        queue.enqueue(65);

        System.out.println(queue.size());
    }
}
