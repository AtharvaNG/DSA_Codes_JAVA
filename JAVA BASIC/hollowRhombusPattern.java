import java.util.*;
public class hollowRhombusPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number: ");
        int n=sc.nextInt();
        int numberOfLines=1;
        int spaces=n-1;
        int stars=n;
        int insideSpaces=n-2;
        while(numberOfLines<=n){
            for(int i=1;i<=spaces;i++){
                System.out.print(" ");
            }
            if(numberOfLines==1 ||numberOfLines==n){
                for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            }else{
                
                System.out.print("*");
                for(int k=1;k<=insideSpaces;k++){
                System.out.print(" ");
            }
            System.out.print("*");
            }
            System.out.println();
            spaces--;
            numberOfLines++;
        }
    }
    
}