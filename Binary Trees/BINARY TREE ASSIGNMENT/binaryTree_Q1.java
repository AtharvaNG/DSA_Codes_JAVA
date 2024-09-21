import java.util.*;
public class binaryTree_Q1 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class binaryTree{
        static int index=-1;
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index]==-1){
                return null;
            }
            Node newNode=new Node(nodes[index]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }

        public static boolean isUnivalued(Node root){  //top to bottom
            if(root==null){
                return true;
            }

            if(root.right!=null && root.right.data!=root.data){
                return false;
            }
            if(root.left!=null && root.left.data!=root.data){
                return false;
            }
            return isUnivalued(root.left) && isUnivalued(root.right);
        }
        //bottom to top
        // public static boolean isUnivalued(Node root){
        //     if(root==null){
        //         return true;
        //     }
        //     boolean left=isUnivalued(root.left);
        //     boolean right=isUnivalued(root.right);

        //     if(left==true && right==true){
        //         if(root.left!=null && root.right!=null){
        //             if(root.left.data==root.data && root.right.data==root.data){
        //                 return true;
        //             }
        //         }
                
        //         else if(root.left==null && root.right!=null){
        //             if(root.right.data==root.data){
        //                 return true;
        //             }
        //         }

        //         else if(root.right==null && root.left!=null){
        //             if(root.left.data==root.data){
        //                 return true;
        //             }
        //         }
        //         else{
        //             return true;
        //         }
        //     }
        //     return false;
        // }

    }
    public static void main(String[] args) {
        int nodes[]={2,2,5,-1,-1,2,-1,-1,2,-1,-1};
        binaryTree tree=new binaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println(tree.isUnivalued(root));

    }
}