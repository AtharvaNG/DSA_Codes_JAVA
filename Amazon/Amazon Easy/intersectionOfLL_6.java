import java.util.*;
public class intersectionOfLL_6 {

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node intersect(Node head1,Node head2){
        if(head1==null || head2==null){
            return null;
        }

        Node p1=head1;
        Node p2=head2;
        while (p1!=p2) {
            p1=p1.next;
            p2=p2.next;
            if(p1==null && p2==null){
                return null;
            }
            if(p1==null){
                p1=head2;
            }
            if(p2==null){
                p2=head1;
            }  
        }
        return p1;
    }
    public static void main(String[] args) {
        intersectionOfLL_6 ll=new intersectionOfLL_6();
        Node head1=ll.new Node(1);
        Node newNode=ll.new Node(2);
        head1.next=newNode;

        newNode=ll.new Node(3);
        head1.next.next=newNode;

        newNode=ll.new Node(4);
        head1.next.next.next=newNode;

        Node head2=ll.new Node(5);
        head2.next=head1.next.next;
        head2.next.next=head1.next.next.next;

        Node inter=intersect(head1, head2);
        System.out.println(inter.data);
    }
}
