import java.util.*;
import java.util.ArrayList;
public class heap {
    static class Heap {
        ArrayList<Integer>arr=new ArrayList<>();

        public void add(int data){
            //step 1 add at last index
            arr.add(data);

            int childIndex=arr.size()-1;
            int partenIndex=(childIndex-1)/2;

            while (childIndex>0 && arr.get(childIndex)<arr.get(partenIndex)) {
                int temp=arr.get(childIndex);
                arr.set(childIndex,arr.get(partenIndex));
                arr.set(partenIndex, temp);
                childIndex=partenIndex;
                partenIndex=(childIndex-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }

        public void heapify(int i){
            int left=(2*i)+1;
            int right=(2*i)+2;
            int min=i;
            if(left<arr.size() && arr.get(left)<arr.get(min)){
                min=left;
            }
            if(right<arr.size() && arr.get(right)<arr.get(min)){
                min=right;
            }

            if(min!=i){
                int temp=arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);

                heapify(min);
            }
        }

        public int remove(){ //removes the root 

            //swap first and last
            int data=arr.get(0);
            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //delet last

            arr.remove(arr.size()-1);

            //fix heap

            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(3);
        h.add(1);
        h.add(5);
        h.add(2);
        h.add(4);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
