import java.util.*;
public class jobSequencing {
    static class Job{
        int deadline;
        int profit;
        int id;

        Job(int i,int p,int d){
            id=i;
            profit=p;
            deadline=d;
        }


    }
    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job>lis=new ArrayList<>();

        for(int i=0;i<jobInfo.length;i++){
            lis.add(new Job(i, jobInfo[i][1], jobInfo[i][0]));
        }
        
        //sorting

        Collections.sort(lis,(obj1,obj2)->obj2.profit-obj1.profit);  //descending order of profit

        ArrayList<Integer>seq=new ArrayList<>();

        int time=0;
        for(int i=0;i<lis.size();i++){
            Job curr=lis.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println("Max jobs = "+seq.size());
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }

    }
}
