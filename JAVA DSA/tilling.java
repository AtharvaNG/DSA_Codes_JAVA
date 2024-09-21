import java.util.*;
public class tilling {
    public static int totalWays(int n){
        if (n==0 || n==1) {
            return 1;
        }
        // //vertical choice
        // int fnm1=totalWays(n-1);
        // //horizontal choice
        // int fnm2=totalWays(n-2);

        // int total=fnm1+fnm2;
        // return total;

        return totalWays(n-1)+totalWays(n-2);

    }
    public static void main(String[] args) {
        System.out.println(totalWays(4));    //2 x n;
    }
}
