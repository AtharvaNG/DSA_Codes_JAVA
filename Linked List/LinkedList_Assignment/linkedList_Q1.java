import java.util.*;

public class linkedList_Q1 {
    public class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public Node getMergingNode(Node head1,Node head2){
        Node temp1=head1;
        Node temp2=head2;
        while (temp1!=null) {
            while (temp2!=null) {
                if(temp2==temp1){
                    return temp2;
                }
                temp2=temp2.next;
            }
            temp2=head2;
            temp1=temp1.next;
        }
        return null;
    }

    public Node getMergingNodeOptimised(Node head1,Node head2){
        Node temp1=head1;
        Node temp2=head2;
        while (temp1!=temp2) {
            temp1=temp1.next;
            temp2=temp2.next;
            if(temp1==null && temp2==null){
                return null;
            }
            else if(temp1==null){
                temp1=head2;
            }
            else if(temp2==null){
                temp2=head1;
            }
        }
        return temp1;
    }
   
    public static void main(String[] args) {
        
        linkedList_Q1 ll=new linkedList_Q1();

        Node head1=ll.new Node(4);
        Node newNode=ll.new Node(5);
        head1.next=newNode;

        newNode=ll.new Node(6);
        head1.next.next=newNode;

        newNode=ll.new Node(7);
        head1.next.next.next=newNode;



        Node head2=ll.new Node(1);
        newNode=ll.new Node(2);
        head2.next=newNode;

        newNode=ll.new Node(3);
        head2.next.next=newNode;

        head2.next.next.next=head1.next.next;
        head2.next.next.next.next=head1.next.next.next;

        Node intersection=ll.getMergingNodeOptimised(head1,head2);

        if(intersection==null){
            System.out.println("No interserction point");
        }
        else{
            System.out.println("Intersection point at: "+intersection.data);
        }
    }
}





//--------------------------------------------------------------------------------------------------------------




// import java.util.*;

// public class linkedList_Q1 {
//     static class Node{
//         int data;
//         Node next;
        
//         Node(int data){
//             this.data=data;
//             this.next=null;
//         }
//     }

//     public static Node merge(Node head1,Node head2){
//         Node temp1=head1;
//         Node temp2=head2;
//         while (temp1!=null) {
//             while (temp2!=null) {
//                 if(temp2==temp1){
//                     return temp2;
//                 }
//                 temp2=temp2.next;
//             }
//             temp2=head2;
//             temp1=temp1.next;
//         }
//         return null;
//     }
   
//     public static void main(String[] args) {
//         Node head1=new Node(4);
//         Node newNode2=new Node(5);
//         Node newNode3=new Node(6);
//         Node newNode4=new Node(7);
//         head1.next=newNode2;
//         head1.next.next=newNode3;
//         head1.next.next.next=newNode4;

//         Node head2=new Node(1);
//         Node newNode22=new Node(2);
//         Node newNode32=new Node(3);
//         head2.next=newNode22;
//         head2.next.next=newNode32;
//         head2.next.next.next=head1.next.next;
//         head2.next.next.next.next=head1.next.next.next;

//         Node intersect=merge(head1,head2);
//         if(intersect==null){
//             System.out.println("No intersection");
//         }
//         else{
//             System.out.println("Intersection at : "+intersect.data);
//         }

//     }
// }