import java.util.*;
public class coinChange {

    public static int coinChangeTab(int coins[],int sum){
        int dp[][]=new int[coins.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int c=coins[i-1];
                if(c<=j){
                    int include=dp[i][j-c];
                    int exclude=dp[i-1][j];
                    int ans=include+exclude;
                    dp[i][j]=ans;
                }
                else{
                    int exclude=dp[i-1][j];
                    int ans=exclude;
                    dp[i][j]=ans;
                }
            }
        }
        return dp[coins.length][sum];
    }
    public static void main(String[] args) {
        int coins[]={2,5,3,6};
        int sum=10;

        System.out.println(coinChangeTab(coins, sum));
    }
}
