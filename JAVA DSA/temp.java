import java.util.*;

public class temp {
    public static boolean isEven(int n){
        if(n%2==0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int n=4;
        Boolean result=isEven(n);
        System.out.println(result);

    }
}
