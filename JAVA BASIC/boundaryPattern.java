import java.util.*;
public class boundaryPattern {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of lines: ");
        int n=sc.nextInt();
        int numberOfLines=1;
        int stars=n;
        int spaces=n-2;
        while (numberOfLines<=n-1) {
            if(numberOfLines==1 || numberOfLines==n-1){
                
                for(int i=1;i<=stars;i++){
                    System.out.print("*");
                }
                
            }
            else{
                
                System.out.print("*");
                for(int j=1;j<=spaces;j++){
                    System.out.print(" ");
                }
                System.out.print("*");
                
            }
            System.out.println();
            numberOfLines++;
            }
            
        }
    }

