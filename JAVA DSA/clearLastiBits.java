import java.util.*;
public class clearLastiBits {
    public static int clearLast(int n,int i){
        int bitMask=(~0)<<i;
        return bitMask&n;
    }
    public static void main(String[] args) {
        System.out.println(clearLast(15, 2));
    }
}
