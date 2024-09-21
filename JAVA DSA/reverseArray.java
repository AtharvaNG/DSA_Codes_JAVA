import java.util.*;
public class reverseArray {
    public static void reverse(int arr[]){
        int temp;
        int last=(arr.length)-1;
        for(int i=0;i<(arr.length)/2;i++){
           temp=arr[i];
           arr[i]=arr[last];
           arr[last]=temp;
           last--;
        }
        
    }
    public static void main(String[] args) {
        int arr[]={2,4,6,8,10,12};
        reverse(arr);
        for(int i=0;i<(arr.length);i++){
            System.out.print(arr[i]+" ");
        }
    }
}
