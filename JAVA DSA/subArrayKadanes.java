import java.util.*;
public class subArrayKadanes {
    public static void kadanes(int arr[]){
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currentSum+=arr[i];
            if(currentSum<0){
                currentSum=0;
            }

            maxSum=Math.max(maxSum, currentSum);
        }
        if(maxSum==0){        //if the array has only negative numbers
            maxSum=arr[0];
            for(int i=1;i<arr.length;i++){
            if(maxSum<arr[i]){
                maxSum=arr[i];
            }
            }
        }
        System.out.println("Maximum sum of subarray is: "+maxSum);
    }
    public static void main(String[] args) {
        int arr[]={-2,-3,-1,-4};
        kadanes(arr);
    }
}
