import java.util.*;
public class sumOfDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int sum=0;
        int number=n;
        while (n>0) {
            int ld=n%10;
            sum+=ld;
            n/=10;
        }
        System.out.println("Sum of digits of "+number+" = "+sum);
    }
}
