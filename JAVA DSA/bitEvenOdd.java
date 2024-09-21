import java.util.*;
public class bitEvenOdd {
    public static void evenOdd(int n){
        
        if((n&1)==0){
            System.out.println("Even number");
        }else{
            System.out.println("Odd number");
        }
    }
    public static void main(String[] args) {
        evenOdd(8);
        evenOdd(5);
    }
}
