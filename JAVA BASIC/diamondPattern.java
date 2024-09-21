import java.util.*;
public class diamondPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();
        int numberOfLines=1;
        int spaces=n-1;
        int stars=1;
        while(numberOfLines<n*2){
            for(int i=1;i<=spaces;i++){
                System.out.print(" ");
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            
            if(numberOfLines<n){
                stars+=2;
                spaces--;
            }
            else{
                spaces++;
                stars-=2;
            }
            System.out.println();
            numberOfLines++;
        }
    }
}
