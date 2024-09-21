import java.util.*;
public class linearSearch{
    public static void largeAndSmall(int numbers[]){
        int smallest=Integer.MAX_VALUE;
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>largest){
                largest=numbers[i];
            }
            if(numbers[i]<smallest){
                smallest=numbers[i];
            }
        }
        System.out.println("Largest number in array is: "+largest);
        System.out.println("Smallest number in array is: "+smallest);
    }
    public static int linear(int numbers[],int key){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static int linear(String menu[],String key){
        for(int j=0;j<menu.length;j++){
            if(menu[j]==key){
                return j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[]={45,18,7,23,10,99,33};

        // int key=9;
        // int index=linear(numbers,key);
        // if(index==-1){
        //     System.out.println("Key not found");
        // }else{
        //     System.out.println("Key foud at index: "+index);
        // }

        // String menu[]={"Poha","Misla","Vada Pav","Pav Bhaji","Chapati"};
        // String key="Vada";
        // int index=linear(menu,key);
        // if(index==-1){
        //     System.out.println("Key not found");
        // }else{
        //     System.out.println("Key foud at index: "+index);
        // }

        largeAndSmall(numbers);
    }
}