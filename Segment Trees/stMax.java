import java.util.*;
public class stMax {

    static int tree[];

    public static void init(int n){
        tree=new int[4*n];
    }

    public static void creatST(int i,int si,int sj,int arr[]){
        if(si==sj){
            tree[i]=arr[si];
            return;
        }
        int mid=(si+sj)/2;
        creatST(2*i+1, si, mid, arr);  //left subtree
        creatST(2*i+2, mid+1,sj, arr);  //right subtree
        tree[i]=Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static int getMaxUtil(int i,int si,int sj,int qi,int qj,int arr[]){
        if(si>qj ||sj<qi ){
            return Integer.MIN_VALUE;
        }
        else if(qi<=si && sj<=qj){
            return tree[i];
        }
        else{
            int mid=(si+sj)/2;
            int left=getMaxUtil(2*i+1, si, mid, qi, qj, arr);
            int right=getMaxUtil(2*i+2, mid+1, sj, qi, qj, arr);
            return Math.max(left, right);
        }
    }

    public static int getMax(int arr[],int qi,int qj){  //for min number just change max to min in code
        int n=arr.length;
        return getMaxUtil(0,0,n-1,qi,qj,arr);

    }

    public static void updateUtil(int i, int si,int sj,int index,int value){
        if(index<si || index>sj){
            return;
        }

        if(si==sj){  //leave node which is changed
            tree[i]=value;
        }
        
        if(si!=sj){  //non leave
            tree[i]=Math.max(tree[i], value);
            int mid=(si+sj)/2;
            updateUtil(2*i+1, si, mid, index, value);
            updateUtil(2*i+2, mid+1,sj, index, value);
        }
    }

    public static void update(int arr[],int index,int value){
        arr[index]=value;
        int n=arr.length;
        updateUtil(0, 0, n-1, index, value);
    }
    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        init(n);
        creatST(0, 0, n-1, arr);
        // for(int i=0;i<tree.length;i++){
        //     System.out.print(tree[i]+" ");
        // }

        System.out.println(getMax(arr, 2, 5));
        update(arr, 2, 20);
        System.out.println(getMax(arr, 2, 5));
    }
}
