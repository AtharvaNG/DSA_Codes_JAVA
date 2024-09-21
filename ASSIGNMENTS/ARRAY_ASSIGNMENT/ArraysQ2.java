
import java.util.*;
public class ArraysQ2 {
    public static int pivote(int nums[]){
        int left=0;
        int right=nums.length-1;
        while (left<=right) {
            int mid=(left+right)/2;
            if(nums[mid]<nums[mid-1]){
                return mid;
            }
            else if(nums[mid]>nums[left] && nums[mid]>nums[right]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }           
        }
        return -1;
    }
    
    public static int search(int nums[],int target){
        int result;
        int pivote=pivote(nums);
        if(target>nums[0]){
         result=binarySearch(nums,0,pivote-1,target);
        }
        else{
            result=binarySearch(nums,pivote,nums.length-1,target);
        }
        return result;
    }
    public static int binarySearch(int nums[],int start,int last,int target){
        while (start<=last) {
            int mid=(start+last)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[last]==target){
                return last;
            }
            else if(nums[start]==target){
                return start;
            }
            else if(nums[mid]>target){
                last=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[]={4,5,6,7,0,1,2};
        System.out.println(search(nums,8));
        
    }
}
