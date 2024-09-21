import java.util.*;

import org.w3c.dom.Node;
public class linkedList_Q3 {
    public class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public Node swap(Node head,int x,int y){

        Node prevX=null;
        Node currX=head;
        while (currX!=null && currX.data!=x) {
            prevX=currX;
            currX=currX.next;
        }

        Node prevY=null;
        Node currY=head;
        while (currY!=null && currY.data!=y) {
            prevY=currY;
            currY=currY.next;
        }


        if(prevX==null){
            head=currY;
        }
        else{
            prevX.next=currY;
        }
        if(prevY==null){
            head=currX;
        }
        else{
            prevY.next=currX;
        }
        
        Node temp=currX.next;
        currX.next=currY.next;
        currY.next=temp;

        return head;
        
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
    public static void main(String[] args) {
        linkedList_Q3 ll=new linkedList_Q3();

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

        int x=5;
        int y=1;
        ll.print(head);
        head=ll.swap(head,x,y);
        ll.print(head);
    }
}
