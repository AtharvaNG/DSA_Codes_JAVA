import java.util.*;

public class ArrayList_Q1 {
    public static boolean monotonicArrayList(ArrayList<Integer>numbers){
        boolean mi=true;
        boolean md=true;
        for(int i=0;i<numbers.size()-1;i++){
            if(numbers.get(i)<numbers.get(i+1)){
                md=false;
            }
            if(numbers.get(i)>numbers.get(i+1)){
                mi=false;
            }
        }
        return md||mi;
    }
    public static void main(String[] args){
         ArrayList<Integer>numbers=new ArrayList<>();
         numbers.add(1);
         numbers.add(3);
         numbers.add(2);
         //numbers.add(4);

         System.out.println(monotonicArrayList(numbers));
    }
    
}