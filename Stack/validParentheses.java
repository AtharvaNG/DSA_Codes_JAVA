import java.util.*;
public class validParentheses {

    public static boolean isValid(String str){
        Stack<Character>s=new Stack<>();
        char ch;
        for(int i=0;i<str.length();i++){
            ch=str.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                else if(s.peek()=='(' && ch==')' || s.peek()=='[' && ch==']' || s.peek()=='{' && ch=='}'){
                    s.pop();
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        String str="}{()[]{}";
        System.out.println(isValid(str));
    }
}
