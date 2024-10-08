import java.util.*;
public class heapSort {

    public static void heapify(int arr[],int i,int n){
        int left=(2*i)+1;
        int right=(2*i)+2;

        int max=i;
        if(left<n && arr[left]>arr[max]){
            max=left;
        }
        if(right<n && arr[right]>arr[max]){
            max=right;
        }
        if(max!=i){
            int sub=arr[i];
            arr[i]=arr[max];
            arr[max]=sub;

            heapify(arr, max, n);
        }
    }

    public static void heapSort(int arr[]){
        int n=arr.length;
        //create max heap for ascending order
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        //push largest at end
        for(int i=n-1;i>0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;

            heapify(arr,0,i);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,4,5,3};

        heapSort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
