import java.util.*;
public class chocola {
    public static void main(String[] args) {
        int n=4;
        int m=6;
        Integer verCost[]={2,1,3,1,4};
        Integer horCost[]={4,1,2};

        Arrays.sort(verCost,Comparator.reverseOrder());
        Arrays.sort(horCost,Comparator.reverseOrder());

        int hp=1,vp=1;
        int h=0,v=0;
        int cost=0;

        while (h<horCost.length && v<verCost.length) {
            if(horCost[h]<=verCost[v]){   //vertical cut
                cost+=(hp*verCost[v]);
                v++;
                vp++;
            }
            else{
                cost+=(vp*horCost[h]);
                hp++;
                h++;
            }
        }
        while (h<horCost.length) {
            cost+=(vp*horCost[h]);
            hp++;
            h++;
        }
        while (v<verCost.length) {
            cost+=(hp*verCost[v]);
            v++;
            vp++;
        }

        System.out.println("Min cost of cuts = "+ cost);
    }
}
