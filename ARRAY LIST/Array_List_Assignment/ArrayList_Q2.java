import java.util.*;
public class ArrayList_Q2 {
    public static boolean search(ArrayList<Integer>numbers,int n){
        for(int i=0;i<numbers.size();i++){
            if(n==numbers.get(i)){
                return true;
            }
        }
        return false;
    }

    //bruteforce approach - Time Complexity=O(n^2)

    // public static ArrayList<Integer> lonelyNumbers(ArrayList<Integer>numbers,ArrayList<Integer>lonely){
    //     int count;
    //     for(int i=0;i<numbers.size();i++){
    //         count=1;
    //         for(int j=0;j<numbers.size();j++){
    //             if(i==j){
    //                 continue;
    //             }
    //             if(numbers.get(i)==numbers.get(j)){
    //                 count++;
    //             }
    //         }
    //         if(count==1){
    //            int xM1=numbers.get(i)-1;
    //            int xP1=numbers.get(i)+1;
               
    //            if(search(numbers,xM1)==false &&search(numbers, xP1) == false){
    //                 lonely.add(numbers.get(i));
    //            }
    //         }
    //     }
    //     return lonely;
    // }

    //Optimised - Time Complexity=O(nlog n+n);
    public static ArrayList<Integer>lonelyNumbers(ArrayList<Integer>numbers,ArrayList<Integer>lonely){
        Collections.sort(numbers);
        for(int i=0;i<numbers.size();i++){
            if(i==0){
                if(numbers.get(i+1)!=numbers.get(i)+1 && numbers.get(i+1)!=numbers.get(i) ){
                    lonely.add(numbers.get(i));
                }
            }
            else if(i==numbers.size()-1){
                if(numbers.get(i-1)!=numbers.get(i)-1 && numbers.get(i-1)!=numbers.get(i)){
                    lonely.add(numbers.get(i));
                }
            }
            else{
                if(numbers.get(i-1)!=numbers.get(i)-1 && numbers.get(i-1)!=numbers.get(i) && numbers.get(i+1)!=numbers.get(i)+1 && numbers.get(i+1)!=numbers.get(i)){
                    lonely.add(numbers.get(i));
                }
            }
        }
        return lonely;
    }

//another way by creating new arry , but space complexity =O(n) and Time Complexity=O(n)

    public static void main(String[] args) {
        ArrayList<Integer>numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(3);
        ArrayList<Integer>lonely=new ArrayList<>();

        lonelyNumbers(numbers, lonely);
        System.out.println(lonely);

    }
}
