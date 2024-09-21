import java.util.*;
public class bst_Q1 {
    static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int value){
        if(root==null){
            root=new Node(value);
            return root;
        }
        if(root.data>value){
            root.left=insert(root.left, value);
        }
        else{
            root.right=insert(root.right, value);
        }
        return root;
    }
    static int sum=0;
    public static int sumInRange(Node root,int l,int r){
        if(root==null){
            return 0;
        }
        if(l<=root.data && root.data<=r){
            sumInRange(root.left,l, r);
            sum+=root.data;
            sumInRange(root.right,l, r);
        }
        else if(r<root.data){
            sumInRange(root.left, l, r);
        }
        else{  //root.data<l
            sumInRange(root.right, l, r);
        }
        return sum;
    }

    public static void main(String[] args) {
        int value[]={8,5,3,6,11,20};
        Node root=null;
        
        for(int i=0;i<value.length;i++){
            root=insert(root,value[i]);
        }

        sumInRange(root,3 , 6);
        System.out.println(sum);
    }
}