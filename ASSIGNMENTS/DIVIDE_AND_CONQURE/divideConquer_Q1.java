import java.util.*;
public class divideConquer_Q1 {
    public static void mergeSort(String arr[],int start,int end){
        if(start==end){
            return;
        }
        int mid=(start+end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr,start,mid,end);
    }
    public static void merge(String arr[],int start,int mid,int end){
        int p1=start;
        int p2=mid+1;
        int p3=0;
        String sortArr[]=new String[end-start+1];
        while (p1<=mid && p2<=end) {
            if (arr[p1].compareTo(arr[p2])<=0) {
                sortArr[p3]=arr[p1];
                p1++;
                p3++;
            }
            else{
                sortArr[p3]=arr[p2];
                p2++;
                p3++;
            }
        }
        while (p1<=mid) {
            sortArr[p3]=arr[p1];
            p1++;
            p3++;
        }
        while (p2<=end) {
            sortArr[p3]=arr[p2];
            p2++;
            p3++;
        }

        for(int i=0;i<sortArr.length;i++){
            arr[i+start]=sortArr[i];
        }
    }
    public static void main(String[] args) {
        String arr[]={"sun", "earth", "mars", "mercury"};
        mergeSort(arr,0,3);
        System.out.println(Arrays.toString(arr));
    }
    
}
