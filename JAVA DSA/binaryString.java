import java.util.*;
public class binaryString {
    public static void biString(int n,int previousIndex,String newStr){
        if(n==0){
            System.out.println(newStr);
            return;
        }
        if(previousIndex==0){
            biString(n-1,0,newStr+"0");
            biString(n-1, 1, newStr+"1");
        }
        else{
            biString(n-1,0,newStr+"0");
        }
    }
    public static void main(String[] args) {
        biString(3, 0,"");
    }
}
