import java.util.*;
public class climbingStairs {

    public static int climbingRec(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        return climbingRec(n-1)+climbingRec(n-2);
    }

    public static int climbingMemo(int n,int memoArr[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(memoArr[n]!=0){
            return memoArr[n];
        }
        memoArr[n]=climbingMemo(n-1, memoArr)+climbingMemo(n-2, memoArr);
        return memoArr[n];
    }

    public static int climbingTabu(int n){
        int tabuArr[]=new int[n+1];
        tabuArr[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                tabuArr[i]=tabuArr[i-1]+0;
            }
            else{
                tabuArr[i]=tabuArr[i-1]+tabuArr[i-2];
            }
        }
        return tabuArr[n];
    }
    public static void main(String[] args) {
        int n=5;
        //System.out.println(climbingRec(n));
        // int memoArr[]=new int[n+1];
        // System.out.println(climbingMemo(n, memoArr));
        System.out.println(climbingTabu(n));
    }
}
