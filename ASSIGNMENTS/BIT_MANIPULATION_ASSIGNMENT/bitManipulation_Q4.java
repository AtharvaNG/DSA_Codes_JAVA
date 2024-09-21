import java.util.*;
public class bitManipulation_Q4 {
    public static void main(String[] args) {

    //     A=1000001;(65);
    //   ' '=0100000;(32);
    //     a=1100001;(97);
    //     A|' '=a;

        for(char ch='A';ch<='Z';ch++){
            System.out.println((char)(ch|' '));
        }
    }
}
