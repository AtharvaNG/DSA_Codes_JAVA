import java.util.*;
public class circularQueueUsingArray {
    static class Queue{
        static int arr[];
        static int size;
        static int rare;
        static int front;

        Queue(int size){
            this.arr=new int[size];
            this.size=size;
            this.rare=-1;
            this.front=-1;
        }

        public static boolean isEmpty(){
            return rare==-1 && front==-1;
        }

        public static boolean isFull(){
            return (rare+1)%size==front;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
        
            if(front==-1){  //while adding first element
                front=(front+1)%size;
            }
            rare=(rare+1)%size;
            arr[rare]=data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int value=arr[front];
            
            if(front==rare){
                front=rare=-1;
            }
            else{
                front=(front+1)%size;
            }
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
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
