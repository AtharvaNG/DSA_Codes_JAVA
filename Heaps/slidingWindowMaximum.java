import java.util.*;
public class slidingWindowMaximum {

    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        Pair(int value,int index){
            this.value=value;
            this.index=index;
        }
        @Override
        public int compareTo(Pair p2){
            //for ascending 
            //return this.value-p2.value

            //for dscending 
            return p2.value-this.value;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int res[]=new int[arr.length-k+1];
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i], i));
        }
        res[0]=pq.peek().value;
        for(int i=k;i<arr.length;i++){
            while (pq.size()>0 && pq.peek().index<=i-k) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-k+1]=pq.peek().value;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}