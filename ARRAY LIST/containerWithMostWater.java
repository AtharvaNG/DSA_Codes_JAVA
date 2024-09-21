import java.util.*;

public class containerWithMostWater {
    // public static int water(ArrayList<Integer> height){
    //     int maxWater=0;
    //     for(int i=0;i<height.size()-1;i++){
    //         for(int j=i+1;j<height.size();j++){
    //             int ht=Math.min(height.get(i), height.get(j));
    //             int width=j-i;
    //             int waterContent=ht*width;
    //             maxWater=Math.max(maxWater, waterContent);
    //         }
    //     }
    //     return maxWater;
    // }

    public static int water(ArrayList<Integer>height){
        int maxWater=0;
        int lp=0;
        int rp=height.size()-1;
        while (lp<rp) {
            int ht=Math.min(height.get(lp), height.get(rp));
            int width=rp-lp;
            int waterContent=ht*width;
            maxWater=Math.max(maxWater, waterContent);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList <Integer>height=new ArrayList<>();
        height.add(1); 
        height.add(8); 
        height.add(6); 
        height.add(2); 
        height.add(5); 
        height.add(4); 
        height.add(8); 
        height.add(3); 
        height.add(7); 

        System.out.println(water(height));

    }
    
}