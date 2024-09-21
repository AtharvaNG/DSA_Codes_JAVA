import java.util.*;

public class stringCompression {
    public static void compress(String str){
        StringBuilder sb=new StringBuilder("");
        
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while (i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count>1) {
                count.toString();
                sb.append(count);
            }
        }
        
        // sb.toString();
        System.out.println(sb);

    }
    public static void main(String[] args) {
        String str="aaabbcccdd";
        compress(str);
    }
}
