import java.util.*;
public class nQuenes {
    public static boolean isSafe(char board[][],int row,int column){
        //for top
        for(int i=row-1;i>=0;i--){
            if(board[i][column]=='Q'){
                return false;
            }
        }

        //for left diagonal
        for(int i=row-1, j=column-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //for right diagonal
        for(int i=row-1,j=column+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("--------cheese board---------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");;
            }
            System.out.println();
        }
    }
    static int count=0;
    // public static void placeQuenes(char board[][],int row){

    //     if(row==board.length){
    //         printBoard(board);
    //         count++;
            
    //         return;
    //     }
       
    //     for(int j=0;j<board.length;j++){
    //         if(isSafe(board, row, j)){
    //             board[row][j]='Q';
    //             placeQuenes(board, row+1);
    //             board[row][j]='X';
    //         }
            
    //     }
    // }
    public static boolean placeQuenes(char board[][],int row){
        if(row == board.length){
            return true;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                if(placeQuenes(board, row+1)){
                    return true;
                }
                board[row][j]='X';
            }
        }
        return false;
    }
    public static void main(String args[]){
        int n=4;
        char board[][]=new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='X';
            }
        }
        if (placeQuenes(board,0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        }
        else{
            System.out.println("Solution is not possible");
        }
        //System.out.println("Total ways to solve n quenes: "+count);
    }
}

