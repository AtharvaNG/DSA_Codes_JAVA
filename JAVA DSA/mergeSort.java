import java.util.*;
public class mergeSort {
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void merge(int arr[],int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int k=0;
        int temp[]=new int[high-low+1];
        while (i<=mid && j<=high) {
            if(arr[i]>arr[j]){
                temp[k]=arr[j];
                j++;
                k++;
            }
            else{
                temp[k]=arr[i];
                i++;
                k++;
            }
        }
        while (i<=mid) {
            temp[k]=arr[i];
            i++;
            k++;
        }
        while (j<=high) {
            temp[k]=arr[j];
            j++;
            k++;   
        }

        for(i=low;i<=high;i++){
            arr[i]=temp[i-low];
        }
    }
    public static void mergerSort(int arr[],int low ,int high){
        if(low>=high){
            return;
        }
        int mid=(high+low)/2;
        mergerSort(arr, low, mid);
        mergerSort(arr, mid+1, high);
        merge(arr,low,mid,high);

    }
    public static void main(String[] args) {
        int arr[]={4,6,2,8,2,8};
        mergerSort(arr, 0,arr.length-1);
        printArray(arr);
    }
}
