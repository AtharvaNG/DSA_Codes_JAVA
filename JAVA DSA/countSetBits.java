import java.util.*;
public class countSetBits {
    public static int setBits(int n){
        int count=0;
        while (n>0) {
            if ((n & 1)==1) {
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number: ");
        int n=sc.nextInt();
        System.out.println("Number of set bits in "+n+" is "+setBits(n));

    }   
}
