import java.util.*;

class Pair{
    String s;
    int n;

    Pair(int n,String s){
        this.n=n;
        this.s=s;
    }
}

public class loggerRateLimiter_1 {
    public static void main(String[] args) {

        Pair arr[]=new Pair[5];

        arr[0]=new Pair(1, "foo");
        arr[1]=new Pair(2, "bar");
        arr[2]=new Pair(3, "foo");
        arr[3]=new Pair(8, "fba");
        arr[4]=new Pair(11, "foo");

        HashMap<String,Integer>hm=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i].s)){
                int oldTime=hm.get(arr[i].s);
                if(arr[i].n-oldTime>=10){
                    System.out.print(" Ture ");
                    hm.put(arr[i].s, arr[i].n);
                }
                else{
                    System.out.print(" False ");
                }
            }
            else{
                System.out.print(" Ture ");
                hm.put(arr[i].s, arr[i].n);
            }
        }   
    }  
}