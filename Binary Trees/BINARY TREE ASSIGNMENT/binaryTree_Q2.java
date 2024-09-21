import java.util.*;
public class binaryTree_Q2 {
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

        public static void mirror(Node root){
            if(root==null){
                return;
            }

            mirror(root.left);
            mirror(root.right);
            if(root.left!=null && root.right!=null){
                Node temp=root.left;
                root.left=root.right;
                root.right=temp;
            }
            else if(root.left==null){
                root.left=root.right;
                root.right=null;
            }
            else{
                root.right=root.left;
                root.left=null;
            }
            
        }
        public static void levelOrder(Node root){
            if(root==null){
                return;
            }

            Queue<Node>q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node current=q.remove();
                if(current==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(current.data+" ");
                    if(current.left!=null){
                        q.add(current.left);
                    }
                    if(current.right!=null){
                        q.add(current.right);
                    }
                }
                
            }
        }
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        binaryTree tree=new binaryTree();
        Node root=tree.buildTree(nodes);
        tree.levelOrder(root);
        tree.mirror(root);
        tree.levelOrder(root);
    }
}