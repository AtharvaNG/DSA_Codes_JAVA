import java.util.*;
public class hashing_Q3 {
    public static void main(String[] args) {
        String s="tree";
        
        HashMap<Character,Integer>charTofreq=new HashMap<>();
        for(int i=0;i<s.length();i++){
            charTofreq.put(s.charAt(i),charTofreq.getOrDefault(s.charAt(i), 0)+1);
        }

        HashMap<Integer,String>freqTochar=new HashMap<>();
        for (Character ch : charTofreq.keySet() ) {
            freqTochar.put(charTofreq.get(ch), freqTochar.getOrDefault(charTofreq.get(ch), "")+ch);
        }

        StringBuilder br=new StringBuilder();

        for(int i=s.length();i>0;i--){
            if(freqTochar.containsKey(i)){
                String temp=freqTochar.get(i);
                for (Character ch : temp.toCharArray()) {
                    br.append((""+ch).repeat(i));
                }
            }
        }
        System.out.println(br);
    }
}
