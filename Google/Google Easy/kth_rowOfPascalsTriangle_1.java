import java.util.*;
public class kth_rowOfPascalsTriangle_1 {

    public static int[] findRow(int n){
        int arr[]=new int[n+1];
        arr[0]=1;
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                arr[j]+=arr[j-1];
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int n=5;
        int ans[]=findRow(n);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}