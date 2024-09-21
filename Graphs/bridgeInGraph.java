import java.util.*;
public class bridgeInGraph {
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
        graph[3].add(new Edge(3, 5));


        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));


        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));



    }

    public static void dfs(ArrayList<Edge> graph[],boolean visited[],int dt[],int low[],int current,int parent,int time){
        visited[current]=true;
        dt[current]=low[current]=++time;

        for(int i=0;i<graph[current].size();i++){
            Edge e= graph[current].get(i);
            if(e.destination==parent){
                continue;
            }
            else if(visited[e.destination]==false){
                dfs(graph, visited, dt, low, e.destination, current,time);
                low[current]=Math.min(low[current], low[e.destination]);
                if(dt[current]<low[e.destination]){
                    System.out.println("Bridge: "+ current+"----"+e.destination);
                }
            }
            else {     //if(visited[e.destination])==true
                low[current]=Math.min(low[current], dt[e.destination]);
            }
        }
    }

    public static void tarjansAlgo(ArrayList<Edge> graph[],int V){
        boolean visited[]=new boolean[V];
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        for(int i=0;i<V;i++){
            dfs(graph, visited, dt, low, i, -1,time);
        }
    }

    public static void main(String[] args) {

        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[6];
        creatGraph(graph);

        tarjansAlgo(graph, V);
        
    }
}
