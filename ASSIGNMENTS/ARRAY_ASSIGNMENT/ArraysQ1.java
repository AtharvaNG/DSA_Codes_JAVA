import java.util.*;
public class ArraysQ1 {
    public static boolean sameElement(int nums[]){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j){
                    continue;
                }
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3,1};
        if(sameElement(nums)){
            System.out.println("Array has duplicate elements");
        }else{
            System.out.println("Array dont have duplicate element");
        }
       
    }
}
