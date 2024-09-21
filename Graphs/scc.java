import java.util.*;
public class scc {

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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void topoSort(ArrayList<Edge> graph[],Stack<Integer>s,boolean visited[],int current){

        visited[current]=true;
        for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            if(visited[e.destination]==false){
                topoSort(graph, s, visited, e.destination);
            }
        }
         s.push(current);
    }

    public static void dfs(ArrayList<Edge> trans[],boolean visited[],int current){
        visited[current]=true;
        System.out.print(current+" ");
        for(int i=0;i<trans[current].size();i++){
            Edge e=trans[current].get(i);
            if(visited[e.destination]==false){
                dfs(trans, visited, e.destination);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[],int V){
        //Step 1
        boolean visited[]=new boolean[V];
        Stack<Integer>s=new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(visited[i]==false){
                topoSort(graph, s, visited, i);
            }
        }

        //Step 2
        ArrayList<Edge> trans[]=new ArrayList[V];
        for(int i=0;i<trans.length;i++){
            visited[i]=false;
            trans[i]=new ArrayList<>();
        }

        for(int i=0;i<trans.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                trans[e.destination].add(new Edge(e.destination, e.source));
            }
        }

        //Step 3

        while (!s.isEmpty()) {
            int current=s.pop();
            if(visited[current]==false){
                System.out.print("SCC->");
                dfs(trans, visited, current);
                System.out.println();
            }   
        }

    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[5];
        creatGraph(graph);
        kosaraju(graph, V);
    }
}
