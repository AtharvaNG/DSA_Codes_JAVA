import java.util.*;
public class ArrayList_Q3 {
    public static int frequent(ArrayList<Integer>numbers,int key){
        ArrayList<Integer>frequency=new ArrayList<>(Collections.nCopies(1001,0));

        for(int i=0;i<numbers.size()-2;i++){
            if(numbers.get(i)==key){
                int target=numbers.get(i+1);
                frequency.set(target,frequency.get(target)+1);
            }
        }
        int maxValue=0;
        int maxTarget=0;
        for(int i=0;i<frequency.size();i++){
            if(maxValue<frequency.get(i)){
                maxValue=frequency.get(i);
                maxTarget=i;
            }
        }
        return maxTarget;
    }
    public static void main(String[] args) {
        ArrayList<Integer>numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(100);
        numbers.add(200);
        numbers.add(1);
        numbers.add(100);

        System.out.println(frequent(numbers, 1));
    }
}
