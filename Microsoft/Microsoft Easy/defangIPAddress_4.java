import java.util.*;
public class defangIPAddress_4 {

    public static String defang(String ip){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<ip.length();i++){
            if(ip.charAt(i)=='.'){
                str.append("[.]");
            }
            else{
                str.append(ip.charAt(i));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String ip="1.1.1.1.1";
        System.out.println(defang(ip));
    }
}
