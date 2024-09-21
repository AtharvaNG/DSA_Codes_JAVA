import java.util.*;
public class graphAssignmentSet2_Q3 {

    public static boolean dfs(int index,int visited[],ArrayList<Integer> adj[]){

        if(visited[index]==1){
            return false;
        }
        if(visited[index]==0){
            return true;
        }
        visited[index]=0;

        for (int neigh : adj[index]) {
            boolean cycle=dfs(neigh, visited, adj);
            if(cycle){
                return true;
            }
        }
        
        visited[index]=1;
        return false;
    }

    public static boolean cycle(int visited[],int n,ArrayList<Integer> adj[]){
        for(int index=0;index<n;index++){
            if(visited[index]==-1){
                boolean cycle=dfs(index,visited,adj);
                if(cycle){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n=2;
        int pre[][]={{1,0},{0,1}};
        ArrayList<Integer> adj[]=new ArrayList[2];

        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }

        for (int [] neig  : pre) {
            int source=neig[1];
            int destination=neig[0];
            adj[source].add(destination);
        }
        int visited[]=new int[n];
        for(int i=0;i<visited.length;i++){
            visited[i]=-1;
        }

        System.out.println(cycle(visited, n, adj));
    }
}