import java.util.*;
public class fibo {

    public static int fiboRec(int n){
        if(n==0 || n==1){
            return n;
        }
        return fiboRec(n-1)+fiboRec(n-2);
    }

    public static int fiboMemo(int n,int fiboMemoArr[]){
        if(n==0 || n==1){
            return n;
        }
        if(fiboMemoArr[n]!=0){
            return fiboMemoArr[n];
        }
        fiboMemoArr[n]=fiboMemo(n-1, fiboMemoArr)+fiboMemo(n-2, fiboMemoArr);
        return fiboMemoArr[n];
    }

    public static int fiboTabu(int n){
        int fiboTabuArr[]=new int[n+1];
        fiboTabuArr[0]=0;
        fiboTabuArr[1]=1;
        for(int i=2;i<=n;i++){
            fiboTabuArr[i]=fiboTabuArr[i-1]+fiboTabuArr[i-2];
        }
        return fiboTabuArr[n];
    }
    public static void main(String[] args) {
        int n=5;
        //System.out.println(fiboRec(n));
        // int fiboMemoArr[]=new int[n+1];
        // System.out.println(fiboMemo(n, fiboMemoArr));
        System.out.println(fiboTabu(n));
    
    }
}