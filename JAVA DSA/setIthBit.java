import java.util.*;
public class setIthBit {
    public static int set(int n,int i){
        int bitMask=1<<i;
        return n | bitMask;
    }
    public static void main(String[] args) {
        int n=10;
        int i=2;
        System.out.println(set(n, i));
    }
}
