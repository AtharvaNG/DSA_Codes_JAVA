import java.util.*;
public class clearIthBit {
    public static int clear(int n,int i){
        int bitMask=~(1<<i);
        return bitMask&n;
    }
    public static void main(String args[]){
        System.out.println(clear(10, 1));
    }
}
