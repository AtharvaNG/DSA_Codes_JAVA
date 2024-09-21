import java.util.*;
public class mountainRange {

    public static int mountainRangeTab(int n){
        int dp[]=new int[n+1];
        dp[0]=dp[1]=1;

        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                int inside=dp[j];
                int outside=dp[i-1-j];
                dp[i]+=inside*outside;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;

        System.out.println(mountainRangeTab(n));
    }
}
