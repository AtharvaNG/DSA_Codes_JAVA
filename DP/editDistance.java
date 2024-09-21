import java.util.*;
public class editDistance {

    public static int editTab(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){ //same
                    dp[i][j]=dp[i-1][j-1];
                }
                else{   //different
                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int replace=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(add, Math.min(del, replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1="intention";
        String str2="execution";
        System.out.println(editTab(str1, str2));
    }
}
