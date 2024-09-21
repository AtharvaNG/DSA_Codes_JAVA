import java.util.*;
public class binaryTree_Q3 {
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
        

        public static Node removeDuplicates(Node root,int data){
            if(root==null){
                return null;
            }

            root.left=removeDuplicates(root.left, data);
            root.right=removeDuplicates(root.right, data);

            if(root.left==null && root.right==null && root.data==data){
                return null;
            }
            return root;
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
        int nodes[]={1,5,4,-1,-1,5,-1,-1,3,5,-1,-1,-1};
        binaryTree tree=new binaryTree();
        Node root=tree.buildTree(nodes);
        tree.levelOrder(root);
        tree.removeDuplicates(root,5);
        tree.levelOrder(root);

    }
}
