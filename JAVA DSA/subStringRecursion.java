import java.io.BufferedReader;
import java.util.*;
public class subStringRecursion {
    public static void subArray(String str,int start){
        if(start==str.length()){
            return;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=start;i<str.length();i++){
            sb.append(str.charAt(i));
            System.out.print(sb+" ");
        }
        subArray(str, start+1);
    }
    public static void main(String[] args) {
        String str="hello";
        subArray(str,0);
    }
}
