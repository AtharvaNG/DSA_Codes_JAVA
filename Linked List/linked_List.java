import java.util.*;
public class linked_List {

    public class Node {
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }  
    }
    public static Node head;
    public static Node tail;
    public static int size; //by default java initialises it as 0

    // public int size(){
    //     Node temp=head;
    //     int sz=0;
    //     while (temp!=null) {
    //         temp=temp.next;
    //         sz++;
    //     }
    //     return sz;
    // }

    public void addFirst(int data){  //O(1)
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return ;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){  //O(1)
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return ;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){ //O(n)
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
    public void add(int data,int index){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        
        int i=0;
        while (i<index-1) {
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void deletFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return ;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return ;
        }
        int value=head.data;
        head=head.next;
        size--;
    }
    public void deletLast(){
        if(size==0){
            System.out.println("LL is empty");
            return ;
        }
        else if (size==1) {
            int val=head.data;
            head=tail=null;
            return;
        }
        int i=0;
        Node temp=head;
        while (i<size-2) {
            temp=temp.next;
            i++;
        }
        int val=temp.next.data; //tail.data;
        temp.next=null;
        tail=temp;
        size--;
    }

    public void deletNthFromEnd(int n){
        if(n==size){
            deletFirst();
            return;
        }
        else if (n==1) {
            deletLast();
            return;
        }
        int Startindex=size-n;
        int i=0;
        Node prev=head;
        while (i<Startindex-1) {
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
    }

    public int iterativeSearch(int key){ //O(n)
        int i=0;
        Node temp=head;
        while (temp!=null) {
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head,int key){  //O(n)
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int index=helper(head.next, key);
        if(index==-1){
            return -1;
        }
        return index+1;
    }

    public int recursiveSearch(int key){
        return helper(head,key);
    }

    public void reverse(){  //O(n)
        Node prev=null;
        Node curr=head;
        tail=head;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public Node midNode(){
        Node slow=head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        //S1: find mid node
        Node mid=midNode();
        
        //S2: reverse 2nd half
        Node prev=null;
        Node curr=mid;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;

        //check if 1st half equal to 2nd half
        while (right!=null) {
            if(right.data!=left.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return true;
    }

    public boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null ) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while (fast!=null && fast.next!=null ) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return ;
        }
        
        //find meeting point
        slow=head;
        Node prev=null;
        while (slow!=fast) {
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        
        //removing cycle
        prev.next=null;
    }

    public Node getMid(Node head){
        Node slow=head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while (head1!=null && head2!=null) {
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }

        while (head1!=null) {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while (head2!=null) {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        //find mid
        Node mid=getMid(head);
        //divide
        Node rightHead=mid.next;
        mid.next=null;

        Node newLeft=mergeSort(head);
        
        Node newRight=mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }

    public void zigZag(){
        //find mid
        Node mid=getMid(head);
        
        //reverse 2nd half
        Node current=mid.next;
        mid.next=null;
        Node next;
        Node prev=null;
        while (current!=null) {
            next=current.next;
            current.next=prev;

            prev=current;
            current=next;
        }

        //zig-zag
        Node left=head;
        Node right=prev;
        Node nl,nr;

        while (left!=null && right!=null) {
            nl=left.next;
            left.next=right;
            nr=right.next;
            right.next=nl;

            right=nr;
            left=nl;
        }
    }

    public static void main(String[] args) {
        linked_List ll=new linked_List();
        
        //  ll.addFirst(2);
    
        // ll.addFirst(1);

        // ll.addLast(3);
    
        // ll.addLast(4);
        // ll.add(9,2);
        //ll.print();
        //System.out.println(size);
        //ll.deletFirst();
        //ll.print();
        //ll.deletLast();
        //ll.print();
        //System.out.println(size);
        //System.out.println(ll.iterativeSearch(3));
        //System.out.println(ll.recursiveSearch(5));
        //ll.reverse();
        //ll.deletNthFromEnd(2);
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        //ll.addLast(1);
        //ll.print();
        //System.out.println(ll.checkPalindrome());
        // head=ll.new Node(1);
        // Node temp=ll.new Node(2);
        // head.next=temp;
        // head.next.next=ll.new Node(3);
        // head.next.next.next=temp;

        // System.out.println(ll.isCycle());
        // ll.removeCycle();
        // System.out.println(ll.isCycle());

        // ll.addFirst(1);
        // ll.addFirst(4);
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(5);
        // ll.print();
        // ll.head=ll.mergeSort(ll.head);
        // ll.print();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}