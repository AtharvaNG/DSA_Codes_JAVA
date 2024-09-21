import java.util.*;
public class stSum {

    static int tree[];

    public static void init(int n){
        tree=new int[4*n];
    }

    public static int creatST(int arr[],int i,int start,int end){
        if(start==end){
            tree[i]=arr[start];
            return tree[i];
        }
        int mid=(start+end)/2;
        int left=creatST(arr, 2*i+1, start, mid);
        int right=creatST(arr, 2*i+2, mid+1, end);
        tree[i]=left+right;
        return tree[i];
    }

    public static int getSumUtil(int i,int qi,int qj,int si,int sj){
        if(qi>=sj || qj<=si){  //non overlapping
            return 0;
        }
        else if(si>=qi && sj<=qj){   //complete overlapping
            return tree[i];
        }
        else{    //partial overlaping
            int mid=(si+sj)/2;
            int left=getSumUtil(i*2+1, qi, qj, si,mid);
            int right=getSumUtil(i*2+2, qi, qj, mid+1,sj);
            return left+right;
        }
    }

    public static int getSum(int arr[],int qi,int qj){
        int n=arr.length;
        return getSumUtil(0,qi,qj,0,n-1);
    }

    public static void updateUtil(int i,int si,int sj,int index,int value,int diff){
        if(index>sj || index<si){
            return;
        }
        tree[i]+=diff;
        if(si!=sj){
            int mid=(si+sj)/2;
            updateUtil(2*i+1, si,mid, index, value, diff); //left
            updateUtil(2*i+2, mid+1, sj, index, value, diff); //right
        }

    }
    public static void update(int arr[],int index,int value){
        int n=arr.length;
        int diff=value-arr[index];
        arr[index]=value;

        updateUtil(0, 0, n-1,index, value, diff);

    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        creatST(arr, 0, 0, n-1);
        
        // for(int i=0;i<tree.length;i++){
        //     System.out.print(tree[i]+" ");

        System.out.println(getSum(arr, 2, 5));
        update(arr, 2, 2);
        System.out.println(getSum(arr, 2, 5));

        }
    }
