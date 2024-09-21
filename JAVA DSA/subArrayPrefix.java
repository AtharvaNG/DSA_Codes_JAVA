import java.util.*;
public class subArrayPrefix {
    public static void printSubArray(int arr[]){
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int k=1;k<prefix.length;k++){
            prefix[k]=prefix[k-1]+arr[k];
        }
        int sum;
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                
                if(i==0){
                    sum=prefix[j];
                    System.out.println("Sum of subarray form "+arr[i]+" to "+arr[j]+" = "+sum);
                }else{
                    sum=prefix[j]-prefix[i-1];
                    System.out.println("Sum of sub array form "+arr[i]+" to "+arr[j]+" is "+sum);
                }
                
                if(maxSum<sum){
                    maxSum=sum;
                }
                if(minSum>sum){
                    minSum=sum;
                }
            
                System.out.println();
            }
            System.out.println();
            
        }
        
        
        System.out.println("Maximum sum of sub array is "+maxSum);
            System.out.println("Minimun sum of sub array is: "+minSum);
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10};
        printSubArray(arr);
    }
}
