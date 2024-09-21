import java.util.*;
public class butterflyPattern {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int numberOfLines=1;
        int stars=1;
        int spaces=(2*n)-2;

        while (numberOfLines<=n*2) {
            
            
            for(int i=1;i<=stars;i++){
                System.out.print("*");
        
            }
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=stars;k++){
                System.out.print("*");
            }

            if(numberOfLines<n){
                stars++;
                spaces-=2;
            }
            else if(numberOfLines>n){
                stars--;
                spaces+=2;
            }
            System.out.println();
            numberOfLines++;
        }
    }
}
