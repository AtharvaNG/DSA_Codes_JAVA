import java.util.*;
public class backtracking_Q2 {
    public static void recursive_fun(int pos,int len,String str,String ans,char keyPad[][]){
        if(pos==len){
            System.out.println(ans);
            return;
        }
        char ch[]=keyPad[Character.getNumericValue(str.charAt(pos))];
        for(int i=0;i<ch.length;i++){
            recursive_fun(pos+1, len, str, ans+ch[i], keyPad);
        }
    }
    public static void letterCombination(String str,String ans,char keyPad[][]){
        int len=str.length();
        if(len==0){
            System.out.println("null");
            return;
        }
        
            recursive_fun(0,len,str,ans,keyPad);
    }
    public static void main(String[] args) {
        char keyPad[][]={{},
                        {},
                        {'a','b','c'},
                        {'d','e','f'},
                        {'g','h','i'},
                        {'j','k','l'},
                        {'m','n','o'},
                        {'p','q','r','s'},
                        {'t','u','v'},
                        {'w','x','y','z'}};
        String str="23";
        String ans="";
        letterCombination(str,ans,keyPad);
    }
}
