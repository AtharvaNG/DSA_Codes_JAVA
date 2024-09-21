import java.util.*;
public class intersection_union {

    public static void union(int arr1[],int arr2[]){
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            int n=arr1[i];
            hs.add(n);
        }
        for(int i=0;i<arr2.length;i++){
            int n=arr2[i];
            hs.add(n);
        }
        for (Integer integer : hs) {
            System.out.print(integer+", ");
        }
        
    }

    public static void intersection(int arr1[],int arr2[]){
        HashSet<Integer>hs=new HashSet<>();
        HashSet<Integer>hs2=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            int n=arr1[i];
            hs.add(n);
        }
        for(int i=0;i<arr2.length;i++){
        
            int n=arr2[i];
            if(hs.contains(n)){
                hs2.add(n);
               hs.remove(n);
            }
        }
        for (Integer integer : hs2) {
            System.out.println(integer);
        }
    }
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};

        //union(arr1,arr2);
        intersection(arr1, arr2);
    }
}
