import java.util.*;
public class roadCutting {

    public static int roadCuttingTab(int length[],int price[],int totRoad){

        int dp[][]=new int[length.length+1][totRoad+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int l=length[i-1];
                int p=price[i-1];
                if(l<=j){
                    int include=p+dp[i][j-l];
                    int exclude=dp[i-1][j];
                    int ans=Math.max(include, exclude);
                    dp[i][j]=ans;
                }
                else{
                    int exclude=dp[i-1][j];
                    dp[i][j]=exclude;
                }
            }
        }
        return dp[length.length][totRoad];
    }
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int totRoad=8;

        System.out.println(roadCuttingTab(length, price, totRoad));
    }
}
