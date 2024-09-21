import java.util.*;
public class rotatedArray {
    public static int search(int arr[],int target,int si,int ei){
        if(si>ei){
            return -1;
        }
        int mid=(si+ei)/2;
        if(arr[mid]==target){
            return mid;
        }
        //for case 1: mid on line 1
        if(arr[si]<=arr[mid]){
            //for case a: target on left
            if(arr[si]<=target && target<=arr[mid]){
                return search(arr,target,si,mid-1);
            }
            //for case b: target on right
            else{
                return search(arr,target,mid+1,ei);
            } 
        }
        //for case 2: mid on line 2
        else{
            //for case c: target on right
            if(arr[mid]<=target && target<=arr[ei]){
                return search(arr,target,mid+1,ei);
            }
            //for case d: target on left
            else{
                return search(arr,target,mid-1,si);
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2};
        int target=0;
        int si=0;
        int ei=arr.length-1;
        int targetIndex=search(arr,target,si,ei);
        System.out.println(targetIndex);

    }
}
