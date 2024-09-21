import java.util.*;
public class stock {
    public static int stockProfit(int prices[]){
        int buyPrice=Integer.MAX_VALUE;
        int profit=0;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){   //profit
                profit=prices[i]-buyPrice;
                maxProfit=Math.max(maxProfit, profit);
            }else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[]={7,1,5,3,6,4};
        System.out.println("Maximum profit is : "+stockProfit(prices));
        
    }
}
