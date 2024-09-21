import java.util.*;
public class backtracking_Q3 {
    static int []di={2,1,-1,-2,-2,-1,1,2};
    static int[]dj={1,2,2,1,-1,-2,-2,-1};
    public static boolean knights(int i,int j,int matrix[][],int n,int moveNumber){
       
      
        if(moveNumber==n*n){
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    System.out.print(matrix[x][y]+ " ");
                }
                System.out.println();
            }
            return true;
        }
        if(i<0 || j<0 || i>=n|| j>=n || matrix[i][j]!=-1){
            return false;
        }
        matrix[i][j]=moveNumber;
        

        for(int x=0;x<8;x++){
            int newi=i+di[x];
            int newj=j+dj[x];

            boolean res=knights(newi, newj, matrix, n, moveNumber+1);
            if(res==true){
                return res;
            }
        }

        matrix[i][j]=-1;
        return false;
    }
    public static void main(String[] args) {
        int n=8;
        int matrix[][]=new int[n][n];
        int moveNumber=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=-1;
            }
        }
        knights(0,0,matrix,n,moveNumber);
    }
}
