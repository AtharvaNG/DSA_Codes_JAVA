import java.util.*;
public class bellmanFord {

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

    public static void bellmanFord(ArrayList<Edge> graph[],int source){

        int dis[]=new int[graph.length];
        dis[source]=0;
        for(int i=0;i<graph.length;i++){
            if(i!=source){
                dis[i]=Integer.MAX_VALUE;
            }
            
        }

        int V=graph.length;

        for(int i=0;i<V-1;i++){

            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);

                    int u=e.source;
                    int v=e.desination;
                    int wt=e.weight;

                    if(dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]){
                        dis[v]=dis[u]+wt;
                    }
                }
            }
        }
        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }
    }

    public static void creatGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
    }
    public static void main(String[] args) {

        int vertex=5;

        ArrayList<Edge> graph[]=new ArrayList[vertex];

        creatGraph(graph);

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2,-4));
        graph[2].add(new Edge(2, 3,2));
        graph[3].add(new Edge(3, 4,4));
        graph[4].add(new Edge(4, 1,-1));

        bellmanFord(graph, 0);
        
    }
}
