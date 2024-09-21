import java.util.*;
public class greedy_Q3 {
    public static void main(String[] args) {
        int n=5;
        int k=101;
        StringBuilder sb=new StringBuilder();
        while (n>0) {
            if((n-1)*26>=k-1){   //can we add 'a'
                sb.append('a');
                n--;
                k--;
            }
            else{ //which other alphabate can we add
                int position=k%26;
                if(position==0){ 
                    sb.append('z');
                    n--;
                    k-=26;
                }
                else{
                    sb.append((char)(position-1+'a'));
                    n--;
                    k-=position;
                }
            }
        }
       
        System.out.println(sb);
    }
}
