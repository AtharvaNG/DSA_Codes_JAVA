import java.util.*;
public class stringConversion {

    public static int lis(String str1,String str2,int n,int m){
        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int ans1=dp[i][j-1];
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void convert(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        int lisLength=lis(str1,str2,n,m);
        int delet=n-lisLength;
        int insert=m-lisLength;
        System.out.println("Total deletion required: "+delet);
        System.out.println("Total insertion required: "+insert);
    }
    public static void main(String[] args) {
        String str1="pear";
        String str2="sea";
        convert(str1, str2);
    }
}
