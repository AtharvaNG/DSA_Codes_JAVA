import java.util.*;
public class subArray {
    public static void printSubArray(int arr[]){
        int totalSubArray=0;
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<=(arr.length)-1;i++){
            for(int j=i;j<=(arr.length)-1;j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                    sum+=arr[k];
                }
                if(maxSum<sum){
                    maxSum=sum;
                }
                if(minSum>sum){
                    minSum=sum;
                }
                totalSubArray++;
                System.out.println("  Sum of elements of array = "+sum);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total number of subarrays = "+ totalSubArray);
        System.out.println("MAXIMUM sum of lements = "+maxSum);
        System.out.println("MINIMUM sum of lements = "+minSum);
        
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        printSubArray(arr);
    }
}
