import java.util.*;
public class spiralMatrix {
    public static void spiral(int matrix[][]){
        int starRow=0;
        int starColumn=0;
        int endRow=matrix.length-1;
        int endColumn=matrix[0].length-1;

        while (starRow<=endRow && starColumn<=endColumn) {
            //top
            for(int i=starColumn;i<=endColumn;i++){
                System.out.print(matrix[starRow][i]+" ");
            }
            
            //right
            for(int i=starRow+1;i<=endRow;i++){
                System.out.print(matrix[i][endColumn]+" ");
            }

            //bottom
            for(int i=endColumn-1;i>=starColumn;i--){
                if(starRow==endRow){
                    break;
                }
                System.out.print(matrix[endRow][i]+" ");
            }

            //left
            for(int i=endRow-1;i>=starRow+1;i--){
                if(starColumn==endColumn){
                    break;
                }
                System.out.print(matrix[i][starColumn]+" ");

            }

            starRow++;
            starColumn++;
            endRow--;
            endColumn--;
        }

    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiral(matrix);
    }
}
