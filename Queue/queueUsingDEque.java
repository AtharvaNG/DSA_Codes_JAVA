import java.util.*;
public class queueUsingDEque {
    static class Queue{
        Deque<Integer>dq=new LinkedList<>();

        public void add(int data){
            dq.addLast(data);
        }
        public int remove(){
            return dq.removeFirst();
        }
        public int peek(){
            return dq.getFirst();
        }
        public boolean isEmpty(){
            return dq.isEmpty();
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
