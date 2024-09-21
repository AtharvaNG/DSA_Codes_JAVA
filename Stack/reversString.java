import java.util.*;
public class reversString {
    public static String reverse(String str){
        Stack<Character>s=new Stack<>();
        int index=0;
        while (index!=str.length()) {
            s.push(str.charAt(index));
            index++;
        }
        StringBuilder result=new StringBuilder("");
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String str="abc";
        System.out.println(reverse(str));
    }
}
