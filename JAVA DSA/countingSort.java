import java.util.*;
public class countingSort {
    public static void sort(int arr[]){

        //Find the largest element in array
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest, arr[i]);
        }

        //Creating a
        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //sorting
        int j=0;
        for(int i=0;i<count.length;i++){
            while (count[i]>0) {
                arr[j]=i;
                count[i]--;
                j++;
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
        int arr[]={1,4,1,3,2,4,3,7};

        System.out.println("Array before sorting : ");
        printArray(arr);
        sort(arr);
        System.out.println("Array after sorting : ");
        printArray(arr);
    }
}
