import java.util.*;
public class articulationPoint {
    static class Edge {
        int source;
        int destination;

        Edge(int source,int destination){
            this.source=source;
            this.destination=destination;
        }
        
    }
    public static void creatGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
    

        graph[4].add(new Edge(4, 3));

    }

    public static void dfs(ArrayList<Edge> graph[],int dt[],int low[],boolean visited[],int current,int parent,int time,boolean ap[]){
        visited[current]=true;
        int child=0;
        dt[current]=low[current]=++time;
        for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            if(e.destination==parent){
                continue;
            }
            else if(visited[e.destination]==false){
                dfs(graph, dt, low, visited, e.destination, current,time,ap);
                low[current]=Math.min(low[current], low[e.destination]);
                if(parent!=-1 && dt[current]<=low[e.destination]){
                    ap[current]=true;
                }
                child++;
            }
            else{  //visted[e.destination]==true
                low[current]=Math.min(low[current], dt[e.destination]);
            }
        }
        if(parent==-1 && child>1){
            ap[current]=true;
        }
    }

    public static void articulate(ArrayList<Edge> graph[],int V){
        int dt[]=new int[V];
        int low[]=new int[V];
        boolean visited[]=new boolean[V];
        int time=0;
        boolean ap[]=new boolean[V]; //sometimes ap gets repeated ,so to takle it 
        for(int i=0;i<V;i++){
            dfs(graph, dt, low, visited,i, -1,time,ap);
        }
        for(int i=0;i<V;i++){
            if(ap[i]==true){
                System.out.println("AP: "+i);
            }
        }
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[6];
        creatGraph(graph);

        articulate(graph, V);
    }
}
