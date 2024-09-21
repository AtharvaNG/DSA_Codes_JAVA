import java.util.*;
public class insertionSort {
    public static void sort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int prev=i-1;
            int current=arr[i];
            while (prev>=0 && arr[prev]>current) {
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=current;
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
