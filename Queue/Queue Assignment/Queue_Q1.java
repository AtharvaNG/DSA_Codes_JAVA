import java.util.*;
public class Queue_Q1 {
    public static void main(String[] args) {
        Queue<String>q=new LinkedList<>();
        ArrayList<String>lis=new ArrayList<>();
        int n=6;
        q.add("1");
        while (n>0) {
            lis.add(q.peek());
            q.add(q.peek()+"0");
            q.add(q.peek()+"1");
            q.remove(q.peek());
            n--;
        }
        for(int i=0;i<lis.size();i++){
            System.out.print(lis.get(i)+" ");
        }
    }
}
