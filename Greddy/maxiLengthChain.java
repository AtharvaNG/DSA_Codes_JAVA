import java.util.*;
public class maxiLengthChain {
    public static void main(String[] args) {
        int paris[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(paris,Comparator.comparingDouble(o->o[1]));
        int chainLength=1;
        int chainEnd=paris[0][1];

        for(int i=1;i<paris.length;i++){
            if(chainEnd<=paris[i][0]){
                chainLength++;
                chainEnd=paris[i][1];
            }
        }
        System.out.println("Maximum length of chain: "+chainLength);
    }
}
