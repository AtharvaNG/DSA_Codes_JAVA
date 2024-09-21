import java.util.*;
public class searchInSortedMatrix {
    public static boolean search(int arr[][],int key){
        int row=0;
        int colum=arr[0].length-1;
        while (row<arr.length && colum>=0) {
            if(arr[row][colum]==key){
                System.out.println("Key found at ("+row+","+colum+")"); 
                return true;
            }
            else if (key<arr[row][colum]) {
                colum--;
            }
            else{
                row++;
            }
        }
        System.out.println("Key not found");
        return false;

    }
    public static void main(String[] args) {
        int arr[][]={{10,20,30,40},
                     {15,25,35,45},
                    {27,29,37,48},
                    {32,33,39,50}};
        
        search(arr,3);
    }
}
