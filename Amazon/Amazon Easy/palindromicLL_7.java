import java.util.*;
public class palindromicLL_7 {

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node reverse(Node head){
        Node prev=null;
        
        while (head!=null) {
            Node next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }

    public static boolean isPalindromic(Node head){

        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast!=null){ //for odd 
            slow=slow.next;
        }

        slow=reverse(slow);
        fast=head;

        while (slow!=null && fast!=null) {
            if(slow.data!=fast.data){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
    public static void main(String[] args) {
        palindromicLL_7 ll=new palindromicLL_7();
        Node head=ll.new Node(1);
        head.next=ll.new Node(2);
        head.next.next=ll.new Node(3);
        head.next.next.next=ll.new Node(2);
        //head.next.next.next.next=ll.new Node(1);

        System.out.println(isPalindromic(head));
    }
}