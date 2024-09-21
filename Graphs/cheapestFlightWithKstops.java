import java.util.*;
public class cheapestFlightWithKstops {

    static class Edge{
        int source;
        int desination;
        int weight;

        Edge(int source,int destination,int weight){
            this.source=source;
            this.desination=destination;
            this.weight=weight;
        }
    }

    public static void creatGraph(int flights[][],ArrayList<Edge>graph[]){
        
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int s=flights[i][0];
            int d=flights[i][1];
            int c=flights[i][2];
            Edge e=new Edge(s, d, c);

            graph[s].add(e);
        }    
    }

    static class Info {
        int v;
        int cost;
        int stop;

        Info(int v,int c,int s){
            this.v=v;
            this.cost=c;
            this.stop=s;
        } 
    }

    public static int cheapestFlightWith(int n,int flights[][],int source,int destination,int k){
        ArrayList<Edge>graph[]=new ArrayList[n];
        creatGraph(flights, graph);
        int dis[]=new int[graph.length];
        dis[source]=0;
        for(int i=0;i<dis.length;i++){
            if(i!=source){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Info>q=new LinkedList<>();

        q.add(new Info(0, 0, 0));

        while (!q.isEmpty()) {
            Info current=q.remove();

            if(current.stop>k){
                break;
            }

            for(int i=0;i<graph[current.v].size();i++){
                Edge e=graph[current.v].get(i);
                int u=e.source;
                int v=e.desination;
                int w=e.weight;

                if(current.cost+w<dis[v]){
                    dis[v]=current.cost+w;
                    q.add(new Info(v, dis[v], current.stop+1));
                }
            }
        }
        if(dis[destination]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dis[destination];
        }
    }

    public static void main(String[] args) {
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,300}};
        int source=0,destination=3,k=1;

        System.out.println(cheapestFlightWith(4, flights, 0, 3, 1));
        
    }
}
