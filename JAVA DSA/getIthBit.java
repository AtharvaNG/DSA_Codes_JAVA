import java.util.*;
public class getIthBit {
    public static void getBit(int n,int i){
        int bitMask=1<<i;
        if((n&bitMask)==1){
            System.out.println("The bit at "+i+" position of "+n+" is : "+1);
        }
        else{
            System.out.println("The bit at "+i+" position of "+n+" is : "+0);
        }
    }
    public static void main(String[] args) {
        getBit(10, 2);
    }
}
