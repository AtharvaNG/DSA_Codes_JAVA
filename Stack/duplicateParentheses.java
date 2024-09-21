import java.util.*;
public class duplicateParentheses {

    public static boolean isDuplicate(String str){
        Stack<Character>s=new Stack<>();
        char ch;
        for(int i=0;i<str.length();i++){
            ch=str.charAt(i);
            if(ch==')'){
                int count=0;
                while (s.pop()!='(') {
                    count++;
                }
                if(count<1){
                    return true;
                }
            }
            else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str="((a+b))";
        System.out.println(isDuplicate(str));
    }
}
