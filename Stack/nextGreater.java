import java.util.*;
public class nextGreater {
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int nextGreaterElement[]=new int[arr.length];
        Stack<Integer>s=new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            int current=arr[i];
            while (!s.isEmpty() && current>=arr[s.peek()]) {
                s.pop();
            }
            
            if(s.isEmpty()){
                nextGreaterElement[i]=-1;
            }
            else{
                nextGreaterElement[i]=arr[s.peek()];
            }
            s.push(i);
        }

        for(int i=0;i<nextGreaterElement.length;i++){
            System.out.print(nextGreaterElement[i]+" ");
        }
    }
}
