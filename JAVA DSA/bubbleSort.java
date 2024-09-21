import java.util.*;
public class bubbleSort {
    public static void sort(int arr[]){
        int temp;
        int swap=0;
        for(int i=0;i<arr.length-1;i++){
            swap=0;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap++;
                }
            }
            if(swap==0){
                return;
            }
        }
    }
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={5,4,1,3,2};
        System.out.println("Array before sorting : ");
        printArray(arr);
        sort(arr);
        System.out.println("Array after sorting : ");
        printArray(arr);
    }
}
