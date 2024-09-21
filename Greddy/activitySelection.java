import java.util.*;
public class activitySelection {


    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9}; //already sorted

        //if already not sorted,we have to sort with respect ot end
        int activities[][]=new int[start.length][3];
        for(int i=0;i<activities.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        Arrays.sort(activities,Comparator.comparingDouble(o->o[2])); //sorts the array with respect to second index

        ArrayList<Integer>lis=new ArrayList<>();
        int count=1;
        lis.add(activities[0][0]);
        int lastEnd=activities[0][2];
        for(int i=1;i<start.length;i++){
            if(activities[i][1]>=lastEnd){
                lis.add(activities[i][0]);
                count++;
                lastEnd=activities[i][2];
            }
        }
        System.out.println("Number of activities that can be done are: "+count);
        for(int i=0;i<lis.size();i++){
            System.out.print("A"+lis.get(i)+" ");
        }
    }
}