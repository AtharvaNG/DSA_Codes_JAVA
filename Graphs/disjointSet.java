import java.util.*;
public class disjointSet {

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
    public static void main(String[] args) {
        int n=7;
        int parent[]=new int[7];
        int rank[]=new int[7];

        init(n,parent,rank);

        union(1, 3, parent, rank);
        System.out.println(find(3, parent));
        union(2, 4, parent, rank);
        union(6, 3, parent, rank);
        union(1, 4, parent, rank);
        System.out.println(find(3, parent));
        union(1, 5, parent, rank);

    }
}
