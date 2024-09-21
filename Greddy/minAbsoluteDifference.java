import java.util.*;
public class minAbsoluteDifference{
    public static void main (String args[]){
        int a[]={1,4,7,8};
        int b[]={2,3,5,6};
        int min=0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            min+=Math.abs(a[i]-b[i]);
        }
        System.out.println("Min absolute difference of pairs is: "+min);
    }
}