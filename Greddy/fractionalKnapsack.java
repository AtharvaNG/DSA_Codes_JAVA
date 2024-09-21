import java.util.*;
public class fractionalKnapsack {
    public static void main(String[] args) {
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int w=50;

        double ratio[][]=new double[val.length][2];
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=weight[i]/(double)val[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capacity=w;
        int finalVal=0;
        for(int i=0;i<val.length;i++){
            int index= (int)ratio[i][0];
            if(capacity>=weight[index]){  //include full item
                finalVal+=val[index];
                capacity-=weight[index];
            }
            else{//include partial item
                finalVal+=(val[index]*capacity)/weight[index];  
                break;
            }
        }
        System.out.println("Final value = "+finalVal);
    }
}
