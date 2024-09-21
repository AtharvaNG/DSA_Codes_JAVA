import java.util.*;
public class graphAssignmentSet2_Q2 {

    static class Edge {
        int source;
        int destination;
        

        Edge(int source,int destination){
            this.source=source;
            this.destination=destination;
            
        }
        
    }
        
    public static void union(int a,int b,int parent[],int rank[]){
        int parA=find(a, parent);
        int parB=find(b, parent);
        if(rank[parA]==rank[parB]){
            parent[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]){
            parent[parA]=parB;
        }
        else{
            parent[parB]=parA;
        }
    }

    public static int find(int x,int parent[]){
        if(parent[x]==x){
            return x;
        }
        return find(parent[x],parent);   //parten[x]=find(x, parent);  optimised
    }

    public static void init(int n,int parent[],int rank[]){
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }
    public static void creatGraph(ArrayList<Edge>graph){
        graph.add(new Edge(0, 4));
        //graph.add(new Edge(0, 2));
        graph.add(new Edge(4, 2));
        graph.add(new Edge(2, 1));
        graph.add(new Edge(1, 3));
    }

    public static boolean isCycle(ArrayList<Edge>graph,int parent[],int rank[]){
        for (Edge edge : graph) {
            int s=edge.source;
            int d=edge.destination;

            int parS=find(s, parent);
            int parD=find(d, parent);
            if(parD==parS){
                return true;
            }
            if(rank[parD]>rank[parS]){
                parent[parS]=parD;
            }
            if(rank[parD]<rank[parS]){
                parent[parD]=parS;
            }
            if(rank[parD]==rank[parS]){
                parent[parD]=parS;
                rank[parS]++;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        ArrayList<Edge>graph=new ArrayList<>();
        int n=5;
        int parent[]=new int[5];
        int rank[]=new int[5];
        creatGraph(graph);
        init(n,parent,rank);
        System.out.println(isCycle(graph, parent, rank));


    }
}
