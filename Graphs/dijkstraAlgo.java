import java.util.*;
public class dijkstraAlgo {

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

    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        
        Pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path-p2.path;
        }
    }

    public static void creatGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[],int source){
        int dis[]=new int[graph.length];
        boolean visited[]=new boolean[graph.length];
        dis[source]=0;
        for(int i=0;i<dis.length;i++){
            if(i!=source){
                dis[i]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current=pq.remove();

            if(visited[current.n]==false){
                visited[current.n]=true;
                for(int i=0;i<graph[current.n].size();i++){
                    Edge e=graph[current.n].get(i);
                    int u=e.source;
                    int v=e.desination;
                    int wt=e.weight;

                    if(dis[u]+wt<dis[v]){
                        dis[v]=dis[u]+wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
            
        }
        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }
    }

    public static void main(String[] args) {
        int vertex=6;
        ArrayList<Edge> graph[]=new ArrayList[vertex];

        creatGraph(graph);

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 6));

        

        dijkstra(graph, 0);

    }
}
