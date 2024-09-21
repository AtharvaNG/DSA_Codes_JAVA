import java.util.*;
public class Arrays_Q2 {
    public static int sumOfNumbers(int arr[][]){
        int row=1;
        int colum=0;
        int sum=0;
        while (colum<arr[0].length) {
            sum+=arr[row][colum];
            colum++;
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[][]={{1,4,9},
                     {11,4,3},
                     {2,2,3}};
        System.out.println("Sum of elements of second row is "+sumOfNumbers(arr));
    }
}
