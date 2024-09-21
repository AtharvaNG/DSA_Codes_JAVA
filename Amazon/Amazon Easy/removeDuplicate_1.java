import java.util.*;
public class removeDuplicate_1 {

    public static int remove(int nums[]){
        int i=0;
      
        for(int j=1;j<nums.length;j++){
            if(nums[i]<nums[j]){
                int temp=nums[i+1];
                nums[i+1]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int nums[]={0,1,1,1,2,2,3}; //we have sorted array
        //using hasmap space complexity O(n) so we will do it without hasmap

        System.out.println(remove(nums));

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}