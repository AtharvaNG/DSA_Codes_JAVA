import java.util.*;
public class backtrackingSubset {

    public static void subset(String str,String ans,int i){

        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
                return;
            }
            else{
                System.out.println(ans);
                return;
            }
        }

        subset(str,ans+str.charAt(i),i+1);   //yes
        subset(str,ans,i+1);   //no
    }
    public static void main(String[] args) {
         String str="abc";
         String ans="";
         subset(str,ans,0);
    }
}
