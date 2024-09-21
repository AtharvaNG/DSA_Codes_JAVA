import java.util.*;
public class firstLetterToUpperCase {
    public static void toUpperCase(String sentence) {
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(sentence.charAt(0));
        sb.append(ch);
        for(int i=1;i<sentence.length();i++){
            if (sentence.charAt(i)==' ' && i<sentence.length()-1) {
                sb.append(sentence.charAt(i));
                i++;
                sb.append(Character.toUpperCase(sentence.charAt(i)));
            }
            else{
                sb.append(sentence.charAt(i));
            }
        }
        sb.toString();
        System.out.println(sb);
    }
    public static void main(String[] args) {
        String sentence="hi, i am atharva ";
        toUpperCase(sentence);

    }
}
