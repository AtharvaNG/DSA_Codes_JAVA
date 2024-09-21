import java.util.*;
public class queueUsingArray {

    static class Queue{
        static int arr[];
        static int size;
        static int rare;

        Queue(int n){
            this.size=n;
            this.arr=new int[n];
            this.rare=-1;
        }

        public static boolean isEmpty(){
            return rare==-1;
        }

        public static void add(int data){
            if(rare==size-1){
                System.out.println("Queue is full");
                return;
            }
            rare++;
            arr[rare]=data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front=arr[0];
            for(int i=0;i<rare;i++){
                arr[i]=arr[i+1];
            }
            rare--;
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}