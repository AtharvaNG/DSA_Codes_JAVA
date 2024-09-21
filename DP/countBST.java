import java.util.*;
public class countBST {

    public static int countBST_Tab(int n){
        int dp[]=new int[n+1];

        dp[0]=dp[1]=1;

        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                int left=dp[j];
                int right=dp[i-1-j];
                dp[i]+=left*right;
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(countBST_Tab(n));
    }
}
