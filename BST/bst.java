import java.util.*;
public class bst {
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
    
        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        
        public static boolean search(Node root,int value){
            if(root==null){
                return false;
            }
            if(root.data==value){
                return true;
            }
            if(root.data>value){
                return search(root.left, value);
            }
            else{
                return search(root.right, value);
            }
        }

        public static Node findInorderSuccessor(Node root){
            while (root.left!=null) {
                root=root.left;
            }
            return root;
        }

        public static Node delete(Node root,int value){
            if(root.data>value){
                root.left=delete(root.left, value);
            }
            else if(root.data<value){
                root.right=delete(root.right, value);
            }
            else{  //root.data==value
                //case 1-leave node
                if(root.left==null && root.right==null){
                    return null;
                }

                //case 2-only one child
                if(root.left==null){
                    return root.right;
                }
                else if(root.right==null){
                    return root.left;
                }

                //case 3-both children
                Node IS=findInorderSuccessor(root.right);
                root.data=IS.data;
                root.right=delete(root.right, IS.data);
            }
            return root;
        }
        public static void printInRange(Node root,int k1,int k2){
            if(root==null){
                return;
            }
            if(root.data>=k1 && root.data<=k2){
                printInRange(root.left, k1, k2);
                System.out.print(root.data+" ");
                printInRange(root.right, k1, k2);
            }
            else if(root.data<k1){
                printInRange(root.right, k1, k2);
            }
            else{ //root.data>k2
                printInRange(root.left, k1, k2);
            }
        }
        
        public static void printPath(ArrayList<Integer>path){
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i)+"->");
            }
            System.out.println("Null");
        }

        public static void root2leafe(Node root,ArrayList<Integer>path){
            if(root==null){
                return;
            }
            path.add(root.data);
            if(root.left==null && root.right==null){
                printPath(path);
            }
            root2leafe(root.left, path);
            root2leafe(root.right, path);
            path.remove(path.size()-1);
        }

        public static Node findInorderPredecessor(Node root){
            while (root.right!=null) {
                root=root.right;
            }
            return root;
        }

        public static boolean isValidBST(Node root,Node min,Node max){
            if(root==null){
                return true;
            }
            if(min!=null && min.data>=root.data){
                return false;
            }
            if(max!=null && max.data<=root.data){
                return false;
            }
            return isValidBST(root.left,min,root) && isValidBST(root.right, root, max);
        }

        public static void mirrorBST(Node root){
            if(root==null){
                return;
            }
            mirrorBST(root.left);
            mirrorBST(root.right);
            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
        }

        public static Node sortArray2BST(int []value,int start, int end){
            if(start>end){
                return null;
            }
            int mid=(start+end)/2;
            Node root=new Node(value[mid]);
            root.left=sortArray2BST(value, start, mid-1);
            root.right=sortArray2BST(value, mid+1, end);
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

        public static Node sortArrayList2BST(ArrayList<Integer>arr,int start, int end){
            if(start>end){
                return null;
            }
            int mid=(start+end)/2;
            Node root=new Node(arr.get(mid));
            root.left=sortArrayList2BST(arr, start, mid-1);
            root.right=sortArrayList2BST(arr, mid+1, end);
            return root;
        }
        

        public static Node toBalancedBST(Node root){
             ArrayList<Integer>arr=new ArrayList<>();
            inorder(root,arr);
            return sortArrayList2BST(arr, 0, arr.size()-1);
        }

        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        static class Info {

            boolean isBST;
            int size;
            int min;
            int max;

            Info(boolean isBST,int size,int min,int max){
                this.isBST=isBST;
                this.size=size;
                this.min=min;
                this.max=max;
            } 
        }
        static int maxSizeBST=0;
        public static Info largestBST(Node root){
            if(root==null){
                return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
            Info left=largestBST(root.left);
            Info right=largestBST(root.right);
            int size=left.size+right.size+1;
            int min=Math.min(root.data,Math.min(left.min, right.min));

            if(left.max>=root.data || right.min<=root.data){
                return new Info(false, size, min, min);
            }
            if(left.isBST && right.isBST){
                maxSizeBST=Math.max(maxSizeBST, size);
                return new Info(true, size, min, min);
            }
            return new Info(false, size, min, min);
        }

        
        public static ArrayList<Integer> merge2ArrayList(ArrayList<Integer>arr1,ArrayList<Integer>arr2){
            int i=0;
            int j=0;
            ArrayList<Integer>finalArr=new ArrayList<>();
            while (i<arr1.size() && j<arr1.size()) {
                if(arr1.get(i)>arr2.get(j)){
                    finalArr.add(arr2.get(j));
                    j++;
                }
                else{
                    finalArr.add(arr1.get(i));
                    i++;
                }
            }
            while (i<arr1.size()) {
                finalArr.add(arr1.get(i));
                i++;
            }
            while (j<arr2.size()) {
                finalArr.add(arr2.get(j));
                j++;
            }
            return finalArr;
        }

        public static Node merge2BST(Node root1,Node root2){
            ArrayList<Integer>arr1=new ArrayList<>();
            inorder(root1,arr1);
            ArrayList<Integer>arr2=new ArrayList<>();
            inorder(root2,arr2);
            ArrayList<Integer>finalArr=merge2ArrayList(arr1, arr2);
            

            return sortArrayList2BST(finalArr, 0, finalArr.size()-1);
        }
    
    public static void main(String[] args) {
        // int value[]={8,6,5,3,10,11,12};
        // Node root=null;
        
        // for(int i=0;i<value.length;i++){
        //     root=insert(root,value[i]);
        // }
        // preorder(root);
        // System.out.println();
        //inorder(root);
        //System.out.println();
        // if(search(root, 6)){
        //     System.out.println("Found");
        // }
        // else{
        //     System.out.println("Not found");
        // }
        // root=delete(root, 3);
        //inorder(root);
        //printInRange(root, 3, 7);
        //root2leafe(root,new ArrayList<>());
        // if(isValidBST(root,null,null)){
        //     System.out.println("The BST is valid");
        // }
        // else{
        //     System.out.println("The BST is not valid");
        // }
        // mirrorBST(root);
        // System.out.println();
        // inorder(root);
        // if(isValidBST(root,null,null)){
        //     System.out.println("The BST is valid");
        // }
        // else{
        //     System.out.println("The BST is not valid");
        // }

        // Node root=sortArray2BST(value, 0, value.length-1);
        // inorder(root);
        
        // Node root2=toBalancedBST(root);
        // preorder(root2);
        // System.out.println();
        // preorder(root);
            // Node root=new Node(50);
            // root.left=new Node(30);
            // root.left.left=new Node(5);
            // root.left.right=new Node(30);
            // root.right=new Node(60);
            // root.right.left=new Node(45);
            // root.right.right=new Node(70);
            // root.right.right.left=new Node(65);
            // root.right.right.right=new Node(80);
            // Info info=largestBST(root);
            // System.out.println("Largest BST size: "+maxSizeBST);

            Node root1=new Node(2);
            root1.left=new Node(1);
            root1.right=new Node(4);

            Node root2=new Node(9);
            root2.left=new Node(3);
            root2.right=new Node(12);

            Node root=merge2BST(root1, root2);
            preorder(root);
    }
}
