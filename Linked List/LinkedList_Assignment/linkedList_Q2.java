import java.util.*;
public class linkedList_Q2 {
    public class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public void deletN_AfterM(Node head,int n,int m){
        Node temp=head;
        while (temp!=null) {
            for(int i=1;i<m;i++){
                temp=temp.next;
            }
            
            for(int i=0;i<n;i++){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        
    }
    public void print(Node head){ //O(n)
        Node temp=head;
        // if(head==null){
        //     System.out.println("LL is empty");
        //     return;
        // }
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String args[]){
        
        linkedList_Q2 ll=new linkedList_Q2();

        Node head=ll.new Node(1);
        Node newNode=ll.new Node(2);
        head.next=newNode;
        newNode=ll.new Node(3);
        head.next.next=newNode;
        newNode=ll.new Node(4);
        head.next.next.next=newNode;
        newNode=ll.new Node(5);
        head.next.next.next.next=newNode;
        newNode=ll.new Node(6);
        head.next.next.next.next.next=newNode;
        newNode=ll.new Node(7);
        head.next.next.next.next.next.next=newNode;
        newNode=ll.new Node(8);
        head.next.next.next.next.next.next.next=newNode;
        newNode=ll.new Node(9);
        head.next.next.next.next.next.next.next.next=newNode;
        newNode=ll.new Node(10);
        head.next.next.next.next.next.next.next.next.next=newNode;
        int n=2;
        int m=3;
        ll.print(head);
        ll.deletN_AfterM(head,n,m);
        ll.print(head);
    }
}
