import java.util.*;
public class targetSum {

    public static boolean targetSumTab(int arr[],int sum){
        boolean dp[][]=new boolean[arr.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=arr[i-1];
                if(v<=j){
                    boolean include=dp[i-1][j-v];
                    boolean exclude=dp[i-1][j];
                    if(include|| exclude){
                        dp[i][j]=true;
                    }
                }
                else{
                    boolean exclude=dp[i-1][j];
                    if(exclude==true){
                        dp[i][j]=true;
                    }
                }
            }
        }
        return dp[arr.length][sum];
    }
    public static void main(String[] args) {
        int arr[]={4,2,7,1,3};
        int sum=10;
        System.out.println(targetSumTab(arr, sum));
        
    }
}
