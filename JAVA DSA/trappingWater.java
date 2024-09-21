import java.util.*;
public class trappingWater {
    public static int totalWaterTrapped(int height[]){
        int width=1;
        int totalWater=0;
        //calculating left max boundary in array
        int leftMax []=new int[height.length];
        leftMax[0]=height[0];
        for(int i=1;i<leftMax.length;i++){
            leftMax[i]=Math.max(leftMax[i-1], height[i]);
        }

        //calculating right max boundary in array
        int rightMax[]=new int[height.length];
        rightMax[rightMax.length-1]=height[height.length-1];
        for(int i=rightMax.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1], height[i]);
        }
        
        for(int i=0;i<height.length;i++){
            int waterLevel=Math.min(rightMax[i], leftMax[i]);
            totalWater+=(waterLevel-height[i])*width;
        }
        return totalWater;
    }
    public static void main(String[] args) {
        int height []={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Total water trapped is: "+totalWaterTrapped(height));
    }
}
