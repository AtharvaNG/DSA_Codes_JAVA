import java.util.*;
public class buildTree{
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
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
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

        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);

            return Math.max(lh, rh)+1;
        }

        public static int totalNodes(Node root){
            if(root==null){
                return 0;
            }
            int ln=totalNodes(root.left);
            int rn=totalNodes(root.right);
            return ln+rn+1;
        }

        public static int nodeSum(Node root){
            if(root==null){
                return 0;
            }
            int ls=nodeSum(root.left);
            int rs=nodeSum(root.right);
            return ls+rs+root.data;
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int ld=diameter(root.left);
            int rd=diameter(root.right);
            int lh=height(root.left);
            int rh=height(root.right);
            int self=lh+rh+1;

            return Math.max(self, Math.max(rd, ld));
        }

        static class Info{
            int diam;
            int ht;

            Info(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }
        }

        public static Info diameter2(Node root){
            if(root==null){
                return new Info(0,0);
            }

            Info leftInfo=diameter2(root.left);
            Info rightInfo=diameter2(root.right);

            int diam=Math.max(leftInfo.ht+rightInfo.ht+1,Math.max(leftInfo.diam, rightInfo.diam));

            int ht=Math.max(leftInfo.ht, rightInfo.ht)+1;

            return new Info(diam,ht);
        }

        public static boolean isIdentical(Node root,Node subroot) {

            if(root==null && subroot==null){
                return true;
            }

            if(root==null && subroot!=null || root!=null && subroot==null){
                return false;
            }
            if(root.data!=subroot.data){
                return false;
            }
            if(!isIdentical(root.left, subroot.left)){
                return false;
            }
            if(!isIdentical(root.right, subroot.right)){
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node root,Node subroot){ 
            if(root==null){
                return false;
            }
            if(root.data==subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }
            return isSubtree(root.left, subroot)||isSubtree(root.left, subroot);
        }

        static class InfoHD{
            Node node;
            int hd;

            InfoHD(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
        }

        public static void topView(Node root){
            //level order
            Queue<InfoHD>q=new LinkedList<>();
            HashMap<Integer,Node>map=new HashMap<>();
            
            int min=0,max=0;
            q.add(new InfoHD(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                InfoHD current=q.remove();
                if(current==null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    if(!map.containsKey(current.hd)){
                        map.put(current.hd, current.node);
                    }
                    if(current.node.left!=null){
                        q.add(new InfoHD(current.node.left,current.hd-1));
                        min=Math.min(min, current.hd-1);
                    }
                    if(current.node.right!=null){
                        q.add(new InfoHD(current.node.right,current.hd+1));
                        max=Math.max(max,current.hd+1);
                    }
                }
            }
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
        }

        public static void kLevel(Node root,int level,int k){
            if(root==null){
                return;
            }
            if(level==k){
                System.out.print(root.data+" ");
                return;
            }
            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);
        }

        public static boolean getPath(Node root,int n,ArrayList<Node>path){

            if(root==null){
                return false;
            }
            path.add(root);

            if(root.data==n){
                return true;
            }

            boolean leftfound=getPath(root.left, n, path);
            boolean rightfound=getPath(root.right, n, path);

            if(leftfound|| rightfound){
                return true;
            }
            path.remove(root);
            return false;
        }

        public static Node lca(Node root,int n1,int n2){
            ArrayList<Node>path1=new ArrayList<>();
            ArrayList<Node>path2=new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);
            int i=0;
            for(;i<path1.size() && i<path2.size();i++){
                if(path1.get(i)!=path2.get(i)){
                    break;
                }
            }
            return path1.get(i-1);
        }

        public static Node lca2(Node root,int n1,int n2){

            if(root==null || root.data==n1 || root.data==n2){
                return root;
            }

            Node left=lca2(root.left, n1, n2);
            Node right=lca2(root.right, n1, n2);

            if(left==null){
                return right;
            }
            if(right==null){
                return left;
            }

            return root; //when both left and right are not null
        }

        public static int distance(Node root,int n){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int left=distance(root.left, n);
            int right=distance(root.right, n);

            if(left==-1 && right==-1){
                return -1;
            }
            else if(left==-1){
                return right+1;
            }
            else{
                return left+1;
            }
        }

        public static int minDistance(Node root,int n1,int n2){
           Node lca=lca2(root, n1, n2);
            int dis1=distance(lca,n1);
            int dis2=distance(lca,n2);
            return dis1+dis2;
        }

        public static int kAncestor(Node root,int n,int k){
            if(root==null){
                return -1;
            }
            if(root.data==n){
                return 0;
            }
            int left=kAncestor(root.left,n, k);
            int right=kAncestor(root.right,n, k);

            if(left==-1 && right==-1){
                return -1;
            }
            
            int max=Math.max(left, right);

            if(max+1==k){
                System.out.println(root.data);
            }
            return max+1;
        }

        public static int sumTransform(Node root){
            if(root==null){
                return 0;
            }
            int temp=root.data;
            root.data=sumTransform(root.left)+sumTransform(root.right);
            return temp+root.data;
        }
    }
    public static void main(String[] args) {
         int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
         binaryTree tree=new binaryTree();
         Node root=tree.buildTree(nodes);

        // Node subroot=new Node(2);
        // subroot.left=new Node(4);
        //subroot.right=new Node(5);

        //System.out.println(root.data);
        //tree.preorder(root);
        //tree.postorder(root);
        //tree.levelOrder(root);
        //System.out.println(tree.height(root));
        //System.out.println(tree.totalNodes(root));
        //System.out.println(tree.nodeSum(root));
        //System.out.println(tree.diameter(root));
        //System.out.println(tree.diameter2(root).diam);

        //System.out.println(tree.isSubtree(root,subroot));

        //tree.topView(root);
        //tree.kLevel(root, 1, 3);
       //System.out.println(tree.lca(root, 4, 6).data);
       //System.out.println(tree.lca2(root, 4, 5).data);
       //System.out.println(tree.minDistance(root, 4, 6));
       //tree.kAncestor(root, 4, 2);

    //    tree.sumTransform(root);
    //    tree.preorder(root);
    tree.sumTransform(root);
    tree.levelOrder(root);
    }
    
}