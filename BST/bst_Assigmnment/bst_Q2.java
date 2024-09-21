import java.util.*;
public class bst_Q2 {
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
    
    public static void inorder(Node root,ArrayList<Integer>arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }

    public static int min(Node root,int value){
        ArrayList<Integer>arr=new ArrayList<>();
        inorder(root, arr);
        int minDiff=Integer.MAX_VALUE;
        int nearestNode=0;
        for(int i=0;i<arr.size();i++){
            int diff=Math.abs(arr.get(i)-value);
            if(minDiff>diff){
                minDiff=diff;
                nearestNode=arr.get(i);
            }
        }
        return nearestNode;
    }
    public static void main(String[] args) {
        int value[]={4,2,1,3,5};
        Node root=null;
        for(int i=0;i<value.length;i++){
            root=insert(root,value[i]);
        }
        System.out.println(min(root, 3));
    }
}
