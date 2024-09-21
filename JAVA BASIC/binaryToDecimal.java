import java.util.*;
public class binaryToDecimal {
    public static int binToDeci(int bin){
        int pow=0;
        int deci=0;
        while (bin>0) {
            int lastDigit=bin%10;
            deci=deci+(lastDigit*(int)Math.pow(2, pow));
            pow++;
            bin/=10;
        }
        return deci;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        int bin=sc.nextInt();
        System.out.println("Decimal of "+bin+" = " +binToDeci(bin));

    }
}
