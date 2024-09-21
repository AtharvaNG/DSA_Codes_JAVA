import java.util.*;

public class graphSet1_Q1 {

    public static boolean isCyclic(ArrayList<Integer> adj[]){
        boolean visited[]=new boolean[adj.length];
        for(int i=0;i<adj.length;i++){
            if(visited[i]==false){
                if(isCyclicUtil(adj,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicUtil(ArrayList<Integer> adj[],boolean visited[],int current,int parent){
        visited[current]=true;
        for (Integer neigh : adj[current]) {
            if(visited[neigh]==false){
                if(isCyclicUtil(adj, visited, neigh, current)){
                    return true;
                }
                
            }
            else if(visited[neigh]==true && neigh!=parent){
                return true;
            }
        }
        return false;
    }

    public static void addEdge(int s,int d,ArrayList<Integer> adj[]){
        adj[s].add(d);
        adj[d].add(s);
    }
    public static void main(String[] args) {
        int vertex=5;
        ArrayList<Integer> adj[]=new ArrayList[vertex];
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }
        addEdge(0,3,adj);
        addEdge(0,4,adj);
        addEdge(3,4,adj);
        addEdge(4,1,adj);
        addEdge(1,2,adj);

        System.out.println(isCyclic(adj));

    }
}