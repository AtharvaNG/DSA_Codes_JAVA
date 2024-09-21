import java.util.*;
public class palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int original=n;
        int check=0;
        while(n>0){
            int lastDigit=n%10;
            check=(check*10)+lastDigit;
            n=n/10;
        }
        if(original==check){
            System.out.println("It is a palindrome number");
        }else{
            System.out.println("It is not a palindrome number");
        }
    }
}
