import java.util.*;
class DoublyLinkedList {
    public class Node{
        int data;
        Node next;
        Node prev;
    
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;

        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode=new Node(data);
        size+=1;
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        size+=1;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.prev=tail;
        tail.next=newNode;
        tail=newNode;
    }

    public void deletFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return;
        }
        if(size==1){
            int value=head.data;
            head=tail=null;
            size-=1;
            return;
        }
        int value=head.data;
        head=head.next;
        head.prev=null;
        size-=1;
    }
    
    public void deletLast(){
        if(head==null){
            System.out.println("DLL is empty");
            return;
        }
        if(size==1){
            int value=head.data;
            head=tail=null;
            size-=1;
            return;
        }
        tail=tail.prev;
        tail.next=null;
        size-=1;
    }

    public void print(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void reversDLL(){
        
        Node current=head;
        Node prev=null;
        Node next;
        while (current!=null) {
            next=current.next;
            current.next=prev;
            current.prev=next;
            prev=current;
            current=next;
        }
        head=prev;
    }

    public static void main(String args[]){

        DoublyLinkedList dll=new DoublyLinkedList();

        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        // dll.deletFirst();
        // dll.deletLast();
        dll.print();
        dll.reversDLL();
        dll.print();
        //System.out.println(size);
    }

}
