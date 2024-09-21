import java.util.*;
public class mcm {

    public static int mcmRec(int arr[],int i,int j){
        if(i==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mcmRec(arr, i, k);  //arr[i] x arr[k+1]
            int cost2=mcmRec(arr, k+1, j);  //arr[k+1] x arr[j+1]
            int cost3=arr[i]*arr[k+1]*arr[j+1];
            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans, finalCost);
        }
        
        return ans;
    }

    public static int mcmMemo(int arr[],int i,int j,int dp[][]){
        if(i==j){
            dp[i][j]=0;
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1=mcmMemo(arr, i, k, dp);
            int cost2=mcmMemo(arr, k+1, j, dp);
            int cost3=arr[i]*arr[k+1]*arr[j+1];
            int finalCost=cost1+cost2+cost3;
            ans=Math.min(ans, finalCost);
        }
        dp[i][j]=ans;
        return ans;
    }

    public static int mcmTab(int arr[]){
        int n=arr.length;
        int dp[][]=new int[n][n];

        for(int i=0;i<n;i++){  //initialization
            dp[i][i]=0;
        }

        for(int len=2;len<n;len++){
            for(int i=1;i<=n-len;i++){ //row
                int j=i+len-1; //col
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int cost1=dp[i][k];
                    int cost2=dp[k+1][j];
                    int cost3=arr[i-1]*arr[k]*arr[j];
                    int finalCost=cost1+cost2+cost3;
                    dp[i][j]=Math.min(dp[i][j], finalCost);
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,3};
        //int n=arr.length;
        //System.out.println(mcmRec(arr, 0, n-2));
        // int dp[][]=new int[n][n];
        // for(int i= 0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // System.out.println(mcmMemo(arr, 0, n-2, dp));
        
        System.out.println(mcmTab(arr));
    }
}
