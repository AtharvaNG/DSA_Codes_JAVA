import java.util.*;
public class temp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int numberOfLines=1;
        int spaces=n-1;
        int stars=n;
        while (numberOfLines<=n) {
            for(int i=1;i<=spaces;i++){
                System.out.print(" ");
            }
            for(int i=1;i<=stars;i++){
                System.out.print("*");
            }
            System.out.println();
            numberOfLines++;
            spaces-=1;
        }
        
           
        }

    }

