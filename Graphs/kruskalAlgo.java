import java.util.*;
public class kruskalAlgo {

    static class Edge implements Comparable<Edge>{
        int source;
        int destination;
        int weight;

        Edge(int source,int destination,int weight){
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
        @Override
        public int compareTo(Edge e2){
            return this.weight-e2.weight;
        }
    }

    public static void creatGraph(ArrayList<Edge>graph){
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    public static void init(int n,int parent[],int rank[]){
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    }

    public static int find(int x,int parent[]){
        if(parent[x]==x){
            return x;
        }
        return find(parent[x],parent);   //parten[x]=find(x, parent);  optimised
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

    public static void kruskal(ArrayList<Edge>graph,int n,int parent[],int rank[]){
        Collections.sort(graph);
        int cost=0;
        int count=0;
        for(int i=0;count<n-1;i++){
            Edge e=graph.get(i);
            int parA=find(e.source, parent);
            int parB=find(e.destination, parent);
            if(parA!=parB){
                union(e.source, e.destination, parent,rank);
                cost+=e.weight;
                count++;
            }
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {

        ArrayList<Edge>graph=new ArrayList<>();
        int n=4;
        int parent[]=new int[4];
        int rank[]=new int[4];
        creatGraph(graph);
        init(n,parent,rank);

        kruskal(graph, n, parent, rank);
    }
}
