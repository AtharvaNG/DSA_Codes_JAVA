import java.util.*;
public class greedy_Q1{
    public static void main(String[] args) {
        String str="LRRRRLLRLLRL";
        int count=0, l=0,r=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='L'){
                l++;
            }
            if(str.charAt(i)=='R'){
                r++;
            }
            if(l==r){
                count++;
            }
        }
        System.out.println(count);
    }
}