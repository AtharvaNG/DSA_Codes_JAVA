import java.util.*;
public class Recursion_Q3 {
    public static int l=0;
    public static void length(String str,int index){
        if(str.charAt(index)=='\0'){
            System.out.println(l);
        }
        l++;
        length(str, index+1);     //CHECK ONCE, NOT APPROPRIATE
    }
    public static void main(String[] args) {
        String str="Atharva";
        int index=0;
        length(str,index);
    }
}
