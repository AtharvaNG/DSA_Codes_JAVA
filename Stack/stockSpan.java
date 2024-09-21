import java.util.*;
public class stockSpan {

    public static void span(int stock[],int []spanEachDay){
        Stack<Integer>s=new Stack<>();
        spanEachDay[0]=1;
        s.push(0);
        for(int i=1;i<stock.length;i++){
            int currentPrice=stock[i];
            while (!s.isEmpty() && currentPrice>=stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                spanEachDay[i]=i+1;
            }
            else{
                int prevHigh=s.peek();
                spanEachDay[i]=i-prevHigh;
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int stock[]={100,80,60,70,60,85,100};
        int spanEachDay[]=new int[stock.length];
        span(stock,spanEachDay);
        for(int i=0;i<spanEachDay.length;i++){
            System.out.print(spanEachDay[i]+" ");
        }
    }
    
}
