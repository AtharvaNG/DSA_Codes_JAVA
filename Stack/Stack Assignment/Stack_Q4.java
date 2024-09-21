import java.util.*;
public class Stack_Q4 {
    public static int totalWaterTraped(int arr[]){
        int rm[]=new int[arr.length];
        int lm[]=new int[arr.length];

        Stack<Integer>s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            int current=arr[i];
            while (!s.isEmpty() && current>arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                rm[i]=arr[i];
            }
            else{
                rm[i]=arr[s.peek()];
                if(arr[i]<rm[i+1] && rm[i]!=rm[i+1]){
                    rm[i]=rm[i+1];
                    s.pop();
                }
            }
            s.push(i);
        }


        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int current=arr[i];
            while (!s.isEmpty() && current>arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                lm[i]=arr[i];
            }
            else{
                lm[i]=arr[s.peek()];
                if(lm[i-1]>arr[i] && lm[i]!=lm[i-1]){
                    lm[i]=lm[i-1];
                    s.pop();
                }
            }
            s.push(i);
        }
        int totalWater=0;
        for(int i=0;i<arr.length;i++){
            int min=Math.min(rm[i], lm[i]);
            int water=min-arr[i];
            totalWater+=water;
        }
        return totalWater;
    }
    public static void main(String[] args) {
        int arr[]={7,0,4,2,5,0,6,4,0,5};
        System.out.println(totalWaterTraped(arr));
    }
}
