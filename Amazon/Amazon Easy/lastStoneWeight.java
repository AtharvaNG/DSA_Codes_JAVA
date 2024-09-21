import java.util.*;
public class lastStoneWeight {

    public static int lastStone(int arr[]){
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while (pq.size()>1) {
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y){
                pq.add(x-y);
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
    public static void main(String[] args) {
        int arr[]={2,7,4,1,8,1};
        System.out.println(lastStone(arr));
    }
}
