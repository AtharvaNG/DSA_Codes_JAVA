import java.util.*;
public class hashing_Q2 {

    public static void main(String[] args) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int arr[]={2,7,11,15};
        int target=9;
        for(int i=0;i<arr.length;i++){
            int n=arr[i];
            if(hm.containsKey(target-n)){
                System.out.print(i+","+hm.get(target-n));
                break;
            }
            else{
                hm.put(n, i);
            }
        }
    }
}