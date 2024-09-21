import java.util.*;
public class primsAlgo {

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

    public static void creatGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
    }

    static class Pair implements Comparable<Pair> {
    
        int n;
        int cost;

        Pair(int n,int cost){
            this.n=n;
            this.cost=cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }

    public static int prims(ArrayList<Edge> graph[],int source){
        int finalCost=0;
        boolean visited[]=new boolean[graph.length];
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair current=pq.remove();
            
            if(visited[current.n]==false){
                visited[current.n]=true;
                finalCost+=current.cost;
                for(int i=0;i<graph[current.n].size();i++){
                    Edge e=graph[current.n].get(i);
                    pq.add(new Pair(e.desination, e.weight));
                }
            }
            
        }
        return finalCost;

    }

    public static void main(String[] args) {

        int vertex=4;

        ArrayList<Edge> graph[]=new ArrayList[vertex];

        creatGraph(graph);

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));


        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));


        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));


        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        System.out.println(prims(graph, 0));
        
    }
}
