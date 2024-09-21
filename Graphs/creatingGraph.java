
import java.util.*;
public class creatingGraph {
    static class Edge {
        int source;
        int desination;
        int weight;

        Edge(int s,int d,int w){
            this.source=s;
            this.desination=d;
            this.weight=w;
        }
        
    }

    public static void bfs(ArrayList<Edge>graph[]){   //for unconnected components
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                bfsUtil(graph,visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>graph[],boolean visited[]){
        Queue<Integer>q=new LinkedList<>();
        
        q.add(0);
        while (!q.isEmpty()) {
            int current=q.remove();
            if(!visited[current]){
                System.out.print(current+" ");
                visited[current]=true;
                for(int i=0;i<graph[current].size();i++){
                    Edge e=graph[current].get(i);
                    q.add(e.desination);
                }
            }
        }
    }

    public static void creat(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
    }

    public static void dfs(ArrayList<Edge>graph[]){ //for unconnected components

        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfsUtil(graph, i, visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>graph[],int current,boolean visited[]){
        System.out.print(current+" ");
        visited[current]=true;

        for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            if(!visited[e.desination]){
                dfsUtil(graph, e.desination, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>graph[],int start,int end,boolean visited[]){
        if(start==end){
            return true;
        }

        visited[start]=true;
        
        for(int i=0;i<graph[start].size();i++){
            Edge e=graph[start].get(i);
            if(!visited[e.desination] && hasPath(graph, e.desination, end, visited)){
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>graph[]){  //undirectonal
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(detectCycleUtil(graph,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>graph[],boolean visited[],int current ,int parent){ 
        visited[current]=true;
        for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            if(!visited[e.desination]){  //case 3
                if(detectCycleUtil(graph, visited, e.desination, current)){
                    return true;
                }
            }
            else if(visited[e.desination] && e.desination!=parent){   //case 1
                return true;
            }
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>graph[]){
        int color[]=new int[graph.length];
        for(int i=0;i<color.length;i++){
            color[i]=-1;//no color
        }

        Queue<Integer>q=new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=0; //yellow
                while (!q.isEmpty()) {
                    int current=q.remove();
                    for(int j=0;j<graph[current].size();j++){
                        Edge e=graph[current].get(j);
                        if(color[e.desination]==-1){
                            int nextCol=color[current]==0?1:0;
                            color[e.desination]=nextCol;
                            q.add(e.desination);
                        }
                        else if(color[current]==color[e.desination]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean cycleDetect(ArrayList<Edge>graph[]){  //directed graph

        boolean visited[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(cycleDetectUtil(graph,visited,stack,i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectUtil(ArrayList<Edge>graph[],boolean visited[],boolean stack[],int current){
        visited[current]=true;
        stack[current]=true;

        for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            if(stack[e.desination]){
                return true;
            }
            else if(!visited[e.desination] && cycleDetectUtil(graph, visited, stack, e.desination)){
                return true;
            }
        }
        stack[current]=false;
        return false;
    }

    public static void topSort(ArrayList<Edge>graph[]){ //using dfs

        boolean visited[]=new boolean[graph.length];
        Stack<Integer>s=new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                topSortUtil(graph,visited,s,i);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
            
        }
    }

    public static void topSortUtil(ArrayList<Edge>graph[],boolean visited[],Stack<Integer>s,int current){
        visited[current]=true;

        for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            if(!visited[e.desination]){
                topSortUtil(graph, visited, s, e.desination);
            }
        }
        s.push(current);
    }

    public static void getIndeg(ArrayList<Edge>graph[],int inedg[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                inedg[e.desination]++;
            }
        }
    }
    
    public static void topoSort(ArrayList<Edge>graph[]){
        int inedg[]=new int[graph.length];
        getIndeg(graph, inedg);
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<inedg.length;i++){
            if(inedg[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int current=q.remove();

            System.out.print(current+" ");

            for(int i=0;i<graph[current].size();i++){
                Edge e=graph[current].get(i);
                inedg[e.desination]--;
                if(inedg[e.desination]==0){
                    q.add(e.desination);
                }
            }
        }
    }

    public static void printAllPaths(ArrayList<Edge>graph[],int source,int destination,String path){
        if(source==destination){
            System.out.println(path+destination);
            
        }
        
        for(int i=0;i<graph[source].size();i++){
            Edge e=graph[source].get(i);
            printAllPaths(graph, e.desination, destination, path+source);
        }
    }

    public static void main(String[] args) {
        //      Graph
        //      (5)
        // 0-----------1
        //            /\
        //           /  \
        //       (1)/    \(3)
        //         /      \
        //        /        \
        //        2--------3 
        //        |   (1)
        //    (2) |
        //        |
        //        4     


        int vertex=5;

        ArrayList<Edge> graph[]=new ArrayList[5]; //null array

        // for(int i=0;i<vertex;i++){
        //     graph[i]=new ArrayList<>();
        // }
        creat(graph);
        //0-vertex
        graph[0].add(new Edge(0, 1, 5));

        //1-vertex
        //graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        
        //2-vertex
        //graph[2].add(new Edge(2, 1, 1));
        //graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        //3-vertex
        //graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //4-vertex
        //graph[4].add(new Edge(4, 2, 2));

        //2's neighbours

        // for(int i=0;i<graph[2].size();i++){
        //     Edge e=graph[2].get(i);
        //     System.out.println(e.desination);
        // }

        
        //bfs(graph);
        //dfs(graph,0,new boolean [vertex]);
        //System.out.println(hasPath(graph, 1, 4, new boolean[vertex]));
        
        //System.out.println(detectCycle(graph));

        //System.out.println(isBipartite(graph));

        //System.out.println(cycleDetect(graph));

        //topSort(graph);

        //topoSort(graph);

        printAllPaths(graph, 0, 4, "");
    }
}