import java.util.*;
public class decimalToBinary {
    public static int deciToBin(int deci){
        int bin=0;
        int pow=0;
        while (deci>0) {
            int remainder=deci%2;
            bin=bin+(remainder*(int)Math.pow(10,pow)); 
            deci/=2; 
            pow++;
        }
        return bin;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter decimal number: ");
        int deci=sc.nextInt();

        System.out.println("Binary of "+deci+" = "+deciToBin(deci));

    }
}
