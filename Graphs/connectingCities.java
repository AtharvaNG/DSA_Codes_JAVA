import java.util.*;
public class connectingCities {

    static class Info implements Comparable<Info> {
        int node;
        int cost;
        
        Info(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        @Override
        public int compareTo(Info i2){
            return this.cost-i2.cost;
        }
    }

    public static int connect(int cities[][]){
        PriorityQueue<Info>pq=new PriorityQueue<>();
        int finalCost=0;
        pq.add(new Info(0, 0));
        boolean visited[]=new boolean[cities.length];
        while (!pq.isEmpty()) {
            Info current=pq.remove();

            if(visited[current.node]==false){
                visited[current.node]=true;
                finalCost+=current.cost;

                for(int i=0;i<cities[current.node].length;i++){
                    if(cities[current.node][i]!=0){
                        pq.add(new Info(i, cities[current.node][i]));
                    }
                }
            }
        }
        return finalCost;

    }

    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        System.out.println(connect(cities));
    }
}
