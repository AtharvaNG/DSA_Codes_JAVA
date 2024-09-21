import java.util.*;
public class palindrome_2 {

    public static boolean isPalindrome(int num){
        int temp=num;
        int reverse=0;
        while (temp>0) {
            int digit=temp%10;
            reverse=reverse*10;
            reverse+=digit;
            temp/=10;
        }
        if(reverse==num){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int num=121;
        System.out.println(isPalindrome(num));
    }
}
