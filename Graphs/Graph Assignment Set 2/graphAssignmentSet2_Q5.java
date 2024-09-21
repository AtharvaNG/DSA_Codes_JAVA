import java.util.*;
public class graphAssignmentSet2_Q5 {

    static class Pair {
        int r;
        int c;

        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public static int island(int mat[][]){
        ArrayList<Pair>ones=new ArrayList<>();
        int total=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    ones.add(new Pair(i, j));
                }
            }
        }
        for (Pair pair : ones) {
            
            if(pair.c-1>=0 && mat[pair.r][pair.c-1]==0 && pair.c+1<mat[0].length && mat[pair.r][pair.c+1]==0 && pair.r-1>=0 && mat[pair.r-1][pair.c]==0 && pair.r+1<mat.length && mat[pair.r+1][pair.c]==0){
                total++;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int mat[][]={{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(island(mat));

    }
}
