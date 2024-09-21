import java.util.*;
public class Recursion_Q2 {
    public static String english[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static void numbersToEnglish(int number){
        if(number<=0){
            return;
        }
        int ld=number%10;
        number/=10;
        numbersToEnglish(number);
        System.out.print(english[ld]+" ");

    }
    public static void main(String[] args) {
        int number=1234;
        numbersToEnglish(number);

    }
}
