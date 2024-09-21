import java.util.*;
public class divideConquer_Q2 {
    public static int majority(int nums[]){
        int winner=nums[0];
        int lead=1;
        for(int i=1;i<nums.length;i++){
            if (nums[i]==winner) {
                lead++;
            }
            else if(lead<0){
                winner=nums[i];
                lead++;
            }
            else{
                lead--;
            }
        }
        return winner;
    }
    public static void main(String[] args) {
        int nums[]={3,2,3};
        System.out.println(majority(nums));
    }
}
