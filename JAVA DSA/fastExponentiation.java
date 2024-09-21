import java.util.*;
public class fastExponentiation {
    public static int exponentiation(int a,int n){
        int ans=1;
        while (n>0) {
            if ((n & 1)==1) {
                ans*=a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int a=2;
        int n=10;
        System.out.println(exponentiation(a,n));
        
    }
}
