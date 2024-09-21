import java.util.*;
public class binaryTree_Q4 {
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

        static HashMap<String

        public static String findSubTrees(Node root){
            if(root==null){
                return "";
            }
            String str="(";
            str+=findSubTrees(root.left);
            str+=Integer.toString(root.data);
            str+=findSubTrees(root.right);

            if(m.get(str)==1){
                System.out.print(str+" ");
                
            }
            if(m.containsKey(str)){
                m.put(str,m.get(str)+1);
            }
            else{
                m.put(str, 1);
            }
            return str;
        }
    }
    public static void main(String[] args) {
        int nodes[]={1,5,4,-1,-1,5,-1,-1,3,5,-1,-1,-1};
        binaryTree tree=new binaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println(tree.findSubTrees(root));

    }
}
