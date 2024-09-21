import java.util.*;
public class signOfProductOfArray_1 {

    public static int sign(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                return 0;
            }
            else if(arr[i]<0){
                count++;
            }
        }
        if(count%2==1){
            return -1;
        }
        else{
            return 1;
        }
    }
    public static void main(String[] args) {
        int arr[]={-1,-2,-3,-4,3,2,1};
        System.out.println(sign(arr));

        // 1 -> if multiplication of array gives +ve sign
        // -1-> if multiplication of array gives -ve sign
        // 0 -> if multiplication of array gives 0

        
    }
}