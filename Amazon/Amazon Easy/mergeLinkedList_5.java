import java.util.*;
public class mergeLinkedList_5 {

    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
        
    }

    public static Node merge(Node l1, Node l2){
        
        if(l1==null){  //if l1 is empty then return l2
            return l2;
        }
        if(l2==null){   //if l2 is empty then return l1
            return l1;
        }
        Node temp;
        Node ans;

        if(l1.data<l2.data){
            temp=l1;
            ans=l1;
            l1=l1.next;
        }
        else{
            temp=l2;
            ans=l2;
            l2=l2.next;
        }

        while (l1!=null && l2!=null) {
    
            if(l1.data<=l2.data){
                temp.next=l1;
                l1=l1.next;
                temp=temp.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
                temp=temp.next;
            }

        }

        while(l2!=null){
            temp.next=l2;
            l2=l2.next;
            temp=temp.next;
        }
        while(l1!=null){
            temp.next=l1;
            l1=l1.next;
            temp=temp.next;
        }
        return ans;
    }

    public static void printLL(Node head){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        mergeLinkedList_5 ll1=new mergeLinkedList_5();
        Node head1=ll1.new Node(1);
        head1.next=ll1.new Node(2);
        head1.next.next=ll1.new Node(4);


        mergeLinkedList_5 ll2=new mergeLinkedList_5();
        Node head2=ll2.new Node(1);
        head2.next=ll2.new Node(3);
        head2.next.next=ll2.new Node(4);

        Node head=merge(head1,head2);
        printLL(head);
    }
}
