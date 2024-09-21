import java.util.*;
public class gridWays {
    public static int totalWays(int i,int j,int n,int m){
        if(i==n-1 || j==m-1){
            return 1;
        }
        if(i==n || j==m){
            return 0;
        }
        return totalWays(i+1, j, n, m) + totalWays(i, j+1, n, m);
    }

    public static int totalWaysByPermute(int n){
        int fac=1;
        for(int i=n;i>=1;i--){
            fac=fac*n;
        }
        return fac;
    }
    public static void main(String[] args) {
        int n=3;
        int m=3;
        // System.out.println("Total ways for "+ n+" X "+m+" grid are: "+totalWays(0,0,n,m));
        int tw=totalWaysByPermute(n-1+m-1)/(totalWaysByPermute(n-1)*totalWaysByPermute(m-1));
        System.out.println("Total ways for "+ n+" X "+m+" grid are: "+tw);
    }
}
