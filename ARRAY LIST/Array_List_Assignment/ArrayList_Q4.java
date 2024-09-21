import java.util.*;
public class ArrayList_Q4 {
    public static ArrayList<Integer> beautifulArrayList(int n){
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(1);
        while(ans.size()<n) {
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i=0;i<ans.size();i++){
                if(ans.get(i)*2<=n){
                    temp.add(ans.get(i)*2);
                }
            }
            for(int i=0;i<ans.size();i++){
                if(ans.get(i)*2 -1<=n){
                    temp.add(ans.get(i)*2 -1);
                }
            }
            ans=temp;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(beautifulArrayList(4));
    }
}
