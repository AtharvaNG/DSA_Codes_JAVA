import java.util.*;
public class recurssion {
    public static boolean arraySortCheck(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if (arr[i]>arr[i+1]) {
            return false;
        }
        return arraySortCheck(arr, i+1);
    }
    public static int firstOccurance(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
         return firstOccurance(arr, key, i+1);
    }
    public static int lastOccurance(int arr[],int key,int i){
        if(i==-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return lastOccurance(arr, key, i-1);
    }

    public static int powerOptimised(int x,int n){
        if(n==0){
            return 1;
        }
        int halfPower=powerOptimised(x, n/2);
        int halfPowerSq=halfPower*halfPower;

        if(n%2!=0){
            halfPowerSq=halfPowerSq*x;
        }
        return halfPowerSq;
    }
    public static void main(String[] args) {
        // int arr[]={8,3,6,9,5,10,2,5,3};
        // System.out.println(lastOccurance(arr, 5,arr.length-1));

        // int arr[]={1,2,3,5,4};
        // System.out.println(arraySortCheck(arr, 0));

        int x=2;
        int n=5;
        System.out.println(powerOptimised(x, n));
    }
}
