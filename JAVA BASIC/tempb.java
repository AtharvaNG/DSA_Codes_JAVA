import java.util.*;
public class tempb {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int numberOfLines=1;
        int spaces=n-1;

        while (numberOfLines<=n) {

            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int i=1;i<=numberOfLines;i++){
                System.out.print(numberOfLines+" ");
            }
            System.out.println();
            numberOfLines++;
            spaces--;

        }
    }
}
