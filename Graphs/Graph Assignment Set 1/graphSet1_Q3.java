import java.util.*;
public class graphSet1_Q3 {

    static class Pair{
        int row;
        int column;

        Pair(int row,int column){
            this.row=row;
            this.column=column;
        }
    }

    public static int orangeRoting(int arr[][]){
        int row=arr.length;
        int col=arr[0].length;
        Queue<Pair>q=new LinkedList<>();
        int freshOranges=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==2){
                    q.add(new Pair(i, j));
                }
                if(arr[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges==0){
            return 0;
        }
        int rowD[]={-1,1,0,0};
        int colD[]={0,0,-1,1};

        int minutes=0;

        while (!q.isEmpty()) {
            int size=q.size();
            boolean rotenThisTime=false;

            for(int i=0;i<size;i++){
                Pair currrent=q.remove();

                for(int j=0;j<4;j++){
                    int newRow=currrent.row+rowD[j];
                    int newCol=currrent.column+colD[j];

                    if(newRow>=0 && newRow<row && newCol>=0 && newCol<col && arr[newRow][newCol]==1){
                        arr[newRow][newCol]=2;
                        freshOranges--;
                        rotenThisTime=true;
                    }

                }

                
            }
            if(rotenThisTime){
                minutes++;
            }
        }
        return freshOranges==0?minutes:-1;
    }
    public static void main(String[] args) {
        int arr[][]={{2,1,0,2,1},{0,0,1,2,1},{0,0,0,2,1}};
        System.out.println(orangeRoting(arr));

    }
}
