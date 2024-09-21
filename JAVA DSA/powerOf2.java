import java.util.*;
public class powerOf2 {
    public static boolean isPowerOf2(int n){
        return ((n & n-1) == 0);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        if(isPowerOf2(n)){
            System.out.println("Number "+n+" is power of 2");
        }
        else{
            System.out.println("Number "+n+" is not power of 2");
        }
    }
    
}
