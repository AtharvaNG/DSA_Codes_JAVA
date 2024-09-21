import java.util.*;
public class reverseOfNumber {
    public static void main(String arg[]){


        // int n=20052004;
        // while(n>0){
        //     int lastDigit=n%10;
        //     System.out.print(lastDigit);
        //     n/=10;
        // }


        int n=2004;
        int reverse=0;
        while (n>0) {
            int lastDigit=n%10;
            reverse=(reverse*10)+lastDigit;
            n/=10;
        }
        System.out.println(reverse);
    }
}
