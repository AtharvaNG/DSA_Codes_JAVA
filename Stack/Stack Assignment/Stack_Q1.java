import java.util.*;

public class Stack_Q1 {
    static class Node {
        char data;
        Node next;

        Node(char data){
            this.data=data;
            this.next=null;
        }
    }

    public static boolean isPalindrome(Node head){
        Stack<Character>s=new Stack<>();
        Node temp=head;
        while (temp!=null) {
            s.push(temp.data);
            temp=temp.next;
        }

        while(!s.isEmpty()){
            char top=s.pop();
            if(top!=head.data){
                return false;
            }
            head=head.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node head=new Node('a');
        Node tow=new Node('b');
        Node three=new Node('c');
        Node four=new Node('b');
        //Node five=new Node('a');

        head.next=tow;
        tow.next=three;
        three.next=four;
        //four.next=five;
        
        System.out.println("Is palindrome: "+isPalindrome(head));
    }
    
}