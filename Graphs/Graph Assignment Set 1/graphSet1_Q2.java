import java.util.*;
public class graphSet1_Q2 {
    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    public static int minDepth(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right);
        }
        if(root.right==null){
            return minDepth(root.left);
        }
        return Math.min(minDepth(root.right),minDepth(root.left))+1;
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(8);
        root.left.left=new Node(6);
        root.left.right=new Node(5);
        root.right=new Node(2);
        System.out.println(minDepth(root));
    }
}
