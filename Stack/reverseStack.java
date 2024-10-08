import java.util.*;
public class reverseStack {

    public static void pushBottom(Stack<Integer>s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void reverse(Stack<Integer>s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverse(s);
        pushBottom(s, top);
    }

    public static void printStack(Stack<Integer>s){
        while (!s.isEmpty()) {
            int top=s.pop();
            System.out.println(top);
            
        }
    }
    public static void main(String[] args) {
        Stack<Integer>s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);  //4,3,2,1

        reverse(s);
        printStack(s);  //1,2,3,4
    }
}
