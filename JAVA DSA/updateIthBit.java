import java.util.*;
public class updateIthBit {
    public static int update(int n,int i,int newBit){
        n=clear(n,i);  //reffer to clearIthBith 
        int bitMask=newBit<<i;
        return bitMask|n;
    }
    public static void main(String[] args) {
        System.out.println(update(10, 2, 1));
    }
}
