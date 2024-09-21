import java.util.*;
public class indianCoin {
    public static void main(String[] args) {
        Integer coin[]={1,2,5,10,20,50,100,500,2000};

        Arrays.sort(coin,Collections.reverseOrder());

        //Arrays.sort(coin,Comparator.reverseOrder());

        int coinCount=0;
        int amount=590;
        ArrayList<Integer>lis=new ArrayList<>();
        for(int i=0;i<coin.length;i++){
            if(coin[i]<=amount){
                while (coin[i]<=amount) {
                    coinCount++;
                    amount-=coin[i];
                    lis.add(coin[i]);
                }
            }
        }
        System.out.println("Total min coins required: "+coinCount);
        for(int i=0;i<lis.size();i++){
            System.out.print(lis.get(i)+" ");
        }
    }
}
