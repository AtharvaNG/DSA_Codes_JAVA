import java.lang.reflect.Array;
import java.util.*;
public class pairSum {
    // public static boolean sum(ArrayList<Integer>numbers,int target){
    //     for(int i=0;i<numbers.size()-1;i++){
    //         for(int j=i+1;j<numbers.size();j++){
    //             if(numbers.get(i)+numbers.get(j)==target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public static boolean sum(ArrayList<Integer>numbers,int target){
        int lp=0;
        int rp=numbers.size()-1;
        while (lp<rp) {
            if(numbers.get(rp)+numbers.get(lp)<target){
                lp++;
            }
            else if(numbers.get(rp)+numbers.get(lp)>target){
                rp--;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer>numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        int target=5;
        System.out.println(sum(numbers,target));
    }
}
