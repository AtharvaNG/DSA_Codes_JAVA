import java.util.*;
public class Strings_Q4 {
    public static void anagrams(String str1,String str2){
        if(str1.length()==str2.length()){
            str1=str1.toLowerCase();
            str2=str2.toLowerCase();
            char str1Array[]=str1.toCharArray();
            char str2Array[]=str2.toCharArray();
            Arrays.sort(str1Array);
            Arrays.sort(str2Array);
            if(Arrays.equals(str1Array, str2Array)){
                System.out.println(str1+" , "+str2+" are anagrams");
            }
            else{
                System.out.println(str1+" , "+str2+" are not anagrams");
            }
        }
        else{
            System.out.println(str1+" , "+str2+" are not anagrams");
        }
    }
    public static void main(String[] args) {
        String str1="care";
        String str2="radius";
        anagrams(str1, str2);
        
    }
}