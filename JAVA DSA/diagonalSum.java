import java.util.*;
public class diagonalSum {
    public static int sum(int arr[][]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==j){                        //primary diagonal
                    sum+=arr[i][j];
                }
                else if(i+j==arr.length-1){      //secondary diagonal
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }

    public static int sumOptimised(int arr[][]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            //primary sum
            sum+=arr[i][i];

            if(i!=arr.length-1-i){                      //for avoiding repeta
                     //for secondary sum      
                sum+=arr[i][arr.length-1-i];            //i+j=n-1; so j=n-1-i;
            }     
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println("Sum of diagonal elements is: "+sumOptimised(arr));
    }
}
