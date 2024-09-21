import java.util.*;
public class hollowRectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter rows: ");
        int r=sc.nextInt();
        System.out.print("Enter columns: ");
        int c=sc.nextInt();
        int numberOfLines=1;

        while(numberOfLines<=r){
            if(numberOfLines==1 || numberOfLines==r){
                for(int i=1;i<=c;i++){
                    System.out.print("*");
                }
            }else{
                System.out.print("*");
                for(int i=1;i<=c-2;i++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
            numberOfLines++;
        }
    }
}
