import java.util.*;
public class Queue_Q4 {
    public static void reversK_elements(Queue<Integer>q,int k){
        Stack<Integer>s=new Stack<>();
        int temp=k;
        int length=q.size();
        int remaining=length-k;
        while (temp>0) {
            s.push(q.remove());
            temp--;
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while(remaining>0){
            q.add(q.remove());
            remaining--;
        }
        
    }
    public static void main(String[] args) {
        Queue<Integer>q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        int k=5;
        reversK_elements(q,k);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}