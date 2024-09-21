import java.util.*;
public class sudoku {
    public static boolean isSafe(int sudo[][],int digit,int row,int column){
        //column
        for(int j=0;j<9;j++){
            if(sudo[row][j]==digit){
                return false;
            }
        }

        //row
        for(int i=0;i<9;i++){
            if(sudo[i][column]==digit){
                return false;
            }
        }

        //grid
        int sr=(row/3)*3;
        int sc=(column/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudo[i][j]==digit){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean sudokuSolver(int sudo[][],int row,int column){
        if(row==9){
            return true;
        }
        int newRow=row;
        int newColumn=column+1;
        if(column+1==9){
            newRow=row+1;
            newColumn=0;
        }
    
        if(sudo[row][column]!=0){
            return sudokuSolver(sudo, newRow, newColumn);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudo,digit,row,column)){
                sudo[row][column]=digit;
                if(sudokuSolver(sudo, newRow, newColumn)){
                    return true;
                }
                sudo[row][column]=0;
            }
        }
        return false;
    }
    public static void printSudo(int sudo[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudo[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudo[][]={{0,0,8,0,0,0,0,0,0},
                      {4,9,0,1,5,7,0,0,2},
                      {0,0,3,0,0,4,1,9,0},
                      {1,8,5,0,6,0,0,2,0},
                      {0,0,0,0,2,0,0,6,0},
                      {9,6,0,4,0,5,3,0,0},
                      {0,3,0,0,7,2,0,0,4},
                      {0,4,9,0,3,0,0,5,7},
                      {8,2,7,0,0,9,0,1,3}};
        
        if(sudokuSolver(sudo, 0, 0)){
            System.out.println("Solution exists");
            printSudo(sudo);
        }
        else{
            System.out.println("Solution does not exists");
        }
    }
}
