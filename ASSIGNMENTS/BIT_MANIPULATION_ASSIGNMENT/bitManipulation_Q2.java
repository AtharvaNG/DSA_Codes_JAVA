import java.util.*;
public class bitManipulation_Q2 {
    public static void main(String[] args) {
        int a=5;
        int b=9;
        System.out.println("a before swaping: "+a);
        System.out.println("b before swaping: "+b);
        a=a^b;
        b=b^a;
        a=a^b;
        System.out.println("a after swaping: "+a);
        System.out.println("b after swaping: "+b);
    }
    
}
