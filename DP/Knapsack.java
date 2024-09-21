import java.util.*;
public class Knapsack {

    public static int KnapsackRec(int val[],int wt[],int W,int n){
        if(W==0 || n==0){
            return 0;
        }

        if(W>=wt[n-1]){  //capacity is more than current weight
            //include
            int ans1=val[n-1]+KnapsackRec(val, wt, W-wt[n-1], n-1);
            //exclude
            int ans2=KnapsackRec(val, wt, W, n-1);

            return Math.max(ans1, ans2);
        }
        else{    //capacity is less than current weight
            //exclude
            return KnapsackRec(val, wt, W, n-1);
        }
    }

    public static int KnapsackMemo(int val[],int wt[],int W,int n,int dp[][]){  //O(n*W)
        if(n==0 ||W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }

        if(W>=wt[n-1]){
            int ans1=val[n-1]+KnapsackMemo(val, wt, W-wt[n-1], n-1,dp);
            int ans2=KnapsackMemo(val, wt, W, n-1,dp);
            dp[n][W]=Math.max(ans1, ans2);
            return dp[n][W];
        }
        else{
            dp[n][W]=KnapsackMemo(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }

    public static int KnapsackTab(int val[],int wt[],int W){
        int dp[][]=new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){ //for rows
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){ //for columns
            dp[0][i]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int w=wt[i-1];
                int v=val[i-1];
                if(w<=j){
                    int include=v+dp[i-1][j-w];
                    int exclude=dp[i-1][j];
                    dp[i][j]=Math.max(include, exclude);
                }
                else{
                    int exclude=dp[i-1][j];
                    dp[i][j]=exclude;
                }
            }
        }
        return dp[val.length][W];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;

        // int dp[][]=new int[val.length+1][W+1];
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        //System.out.println(KnapsackRec(val, wt, W, val.length));
        //System.out.println(KnapsackMemo(val, wt, W, val.length,dp));
        System.out.println(KnapsackTab(val, wt, W));
        

    }
}
