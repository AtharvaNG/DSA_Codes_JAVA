import java.util.*;
public class minimumPartition {

    public static int minPartiTab(int arr[]){
        int sum=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }

        int w=sum/2;

        int dp[][]=new int[n+1][w+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int val=arr[i-1];
                if(val<=j){
                    int include=val+dp[i-1][j-val];
                    int exclude=dp[i-1][j];
                    dp[i][j]=Math.max(include, exclude);
                }
                else{
                    int exclude=dp[i-1][j];
                    dp[i][j]=exclude;
                }
            }
        }

        int sum1=dp[n][w];
        int sum2=sum-sum1;
        return Math.abs(sum2-sum1);
    }
    public static void main(String[] args) {
        int arr[]={1,6,11,5};
        System.out.println(minPartiTab(arr));
    }
}
