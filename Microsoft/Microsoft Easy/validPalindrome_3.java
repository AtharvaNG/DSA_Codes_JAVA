import java.util.*;
public class validPalindrome_3 {

    public static boolean isPalindrome(String str){
        int start=0;
        int last=str.length()-1;

        while (start<=last) {
            if(!Character.isLetterOrDigit(str.charAt(start))){
                start++;
            }
            else if(!Character.isLetterOrDigit(str.charAt(last))){
                last--;
            }
            else if(Character.toLowerCase(str.charAt(start))!=Character.toLowerCase(str.charAt(last))){
                return false;
            }
            else{
                start++;
                last--;
            }
            
        }
        return true;

    }
    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
}
