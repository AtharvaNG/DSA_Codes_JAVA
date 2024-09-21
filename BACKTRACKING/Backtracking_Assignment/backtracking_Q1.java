import java.util.*;
public class backtracking_Q1 {
    public static void findAllPaths(int i,int j,int matrix[][],int n,boolean visited[][],String psf){
    

        if(i<0 || j<0 || i>=n || j>=n || matrix[i][j]==0 || visited[i][j]==true){
            return;
        }
        if(i==n-1 && j==n-1){
            System.out.println("Reached Destination with path "+psf);
            return;
        }

        visited[i][j]=true;

        findAllPaths(i-1, j, matrix, n,visited,psf+"U");  //UP
        findAllPaths(i+1, j, matrix, n,visited,psf+"D");  //DOWN
        findAllPaths(i, j-1, matrix, n,visited,psf+"L");  //LEFT
        findAllPaths(i, j+1, matrix, n,visited,psf+"R");  //RIGHT

        visited[i][j]=false;
    }
    public static void main(String[] args) {
        int matrix[][]={{1,1,1,0,1},
                        {1,0,1,0,1},
                        {1,1,1,1,1},
                        {1,0,1,0,1},
                        {1,1,1,0,1}};
        int n=matrix.length;
        boolean visited[][]=new boolean[n][n];
        String psf="";
        
        findAllPaths(0,0,matrix,n,visited,psf);
    }
}