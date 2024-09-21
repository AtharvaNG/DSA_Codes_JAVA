import java.util.*;
public class maxRectangularAreaHistogram {

    public static int maxRectangularArea(int arr[]){
        int nsl[]=new int[arr.length];
        int nsr[]=new int[arr.length];

        int maxArea=0;

        //find next smaller right 

        Stack<Integer>s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            int current=arr[i];
            while (!s.isEmpty() && current<=arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }


        //find next smaller left
        s=new Stack<>();  //stack khali ho jaega
        for(int i=0;i<arr.length;i++){
            int current=arr[i];
            while (!s.isEmpty() && current<=arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        //calculate area
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int area=height*width;
            maxArea=Math.max(maxArea, area);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println("Maximum area of histogram is: "+maxRectangularArea(arr));
    }
}
