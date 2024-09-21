import java.util.*;
public class missingElement_4 {

    public static int missing(int arr[]){
        int n_XOR=arr.length;
        for(int i=0;i<arr.length;i++){
            n_XOR^=i^arr[i];           
        }
        return n_XOR;
    }
    public static void main(String[] args) {
        int arr[]={3,0,1};
        System.out.println(missing(arr));
    }
}
