import java.util.*;
public class palindromePattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number: ");
        int n=sc.nextInt();
        int numberOfLines=1;
        int spaces=n-1;
        int stars=1;
        while (numberOfLines<=n) {
            for(int i=1;i<=spaces;i++){
                System.out.print("  ");
            }
            int currentNumber=numberOfLines;
            for(int i=1;i<=stars;i++){
                
                System.out.print(currentNumber+" ");
                if(i<=stars/2){
                    currentNumber--;
                }
                else{
                    currentNumber++;
                }

            }
            stars+=2;
            spaces--;
            System.out.println();
            numberOfLines++;
        }
    }
}
