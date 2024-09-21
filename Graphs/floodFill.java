import java.util.*;
public class floodFill {

    public static void helper(int image[][],int sr,int sc,int color,boolean visited[][],int orgCol){

        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || visited[sr][sc]==true || image[sr][sc]!=orgCol){
            return;
        }

        image[sr][sc]=color;
        visited[sr][sc]=true;

        //left
        helper(image, sr, sc-1, color, visited, orgCol);

        //right
        helper(image, sr, sc+1, color, visited, orgCol);

        //up
        helper(image, sr-1, sc, color, visited, orgCol);

        //down
        helper(image, sr+1, sc, color, visited, orgCol);
    }

    public static int [][] fill(int image[][],int sr,int sc,int color){
        boolean visited[][]=new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,visited,image[sr][sc]);
        return image;
    }
    public static void main(String[] args) {
        int image[][]={{1,1,1},{1,1,0},{1,0,1}};
        int sr=1;
        int sc=1;
        int color=2;
        fill(image, sr, sc, color);

        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
