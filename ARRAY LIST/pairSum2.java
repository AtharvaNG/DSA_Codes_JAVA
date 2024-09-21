import java.util.*;
public class pairSum2 {
    public static int mid(ArrayList<Integer>numbers){
        int pivote=-1;
        for(int i=0;i<numbers.size()-1;i++){
            if(numbers.get(i)>numbers.get(i+1)){
                pivote=i+1;
                break;
            }
        }
        return pivote;
    }
    public static boolean sum(ArrayList<Integer>numbers,int target){
        int n=numbers.size();
        int pivote=mid(numbers);
        int lp=pivote;
        int rp=pivote-1;
        while (lp!=rp) {
            if(numbers.get(lp)+numbers.get(rp)<target){
                lp=(lp+1)%n;
            }
            else if(numbers.get(lp)+numbers.get(rp)>target){
                rp=(n+rp-1)%n;
            }
            else{
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        ArrayList<Integer>numbers=new ArrayList<>();
        numbers.add(11);
        numbers.add(15);
        numbers.add(6);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        int target=16;
        System.out.println(sum(numbers,target));
    }
}
