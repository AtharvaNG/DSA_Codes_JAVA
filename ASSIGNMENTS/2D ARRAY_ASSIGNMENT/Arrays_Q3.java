import java.util.*;
public class Arrays_Q3 {
    public static void printArray(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void transpose(int arr[][]){
        int row=arr.length;
        int coulm=arr[0].length;
        int transpose[][]=new int[coulm][row];
        for(int i=0;i<transpose.length;i++){
            for(int j=0;j<transpose[0].length;j++){
                transpose[i][j]=arr[j][i];
            }
        }
        printArray(transpose);
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3},
                     {4,5,6},};

        System.out.println("Array before transpose");
        printArray(arr);
        System.out.println("Array ater transpose");
        transpose(arr);
    }
}
