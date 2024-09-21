import java.util.*;

public class leapYear{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a year: ");
        int n=sc.nextInt();

        boolean x= n%4==0;
        boolean y= n%100!=0;
        boolean z= n%100==0 && n%400==0;

        if(x&&(y||z)){
            System.out.println("It is a leap year");
        }else{
            System.out.println("It is not a leap year");
        }
    }
}












