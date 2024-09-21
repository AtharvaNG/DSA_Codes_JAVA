import java.util.*;
public class greedy_Q4 {
    public static void main(String[] args) {
        int stocks[]={7,1,5,3,6,4};
        int min_buy=stocks[0];
        int profit=0;
        int maxProfit=0;
        for(int i=1;i<stocks.length;i++){
            if(min_buy>stocks[i]){
                min_buy=stocks[i];
            }
            else{
                profit=stocks[i]-min_buy;
                maxProfit=Math.max(maxProfit,profit);
            }
        }
        System.out.println(maxProfit);
    }
}
