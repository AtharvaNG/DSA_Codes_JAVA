import java.util.*;
public class removeDuplicates {
    public static void remove(String str,int index,boolean map[],StringBuilder newString){
        if(index==str.length()){
            System.out.println(newString);
            return;
        }
        char current=str.charAt(index);
        if(map[current-'a']==true){  //for duplicate
            remove(str, index+1, map, newString);
        }
        else{
            map[current-'a']=true;
            remove(str, index+1, map, newString.append(str.charAt(index)));
        }
    }
    public static void main(String[] args) {
        String str="cbacdcbc";
        boolean map[]=new boolean[26];
        StringBuilder newStrig=new StringBuilder();
        remove(str,0,map, newStrig);
    }
}
