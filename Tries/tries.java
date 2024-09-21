import java.util.*;
public class tries {
    static class Node{
        Node []children=new Node[26];
        boolean eow=false;

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }

    static Node root=new Node();

    public static void insert(String s){
        Node current=root;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(current.children[index]==null){
                current.children[index]=new Node();  
            }
            current=current.children[index];
        }
        current.eow=true;
    }

    public static boolean search(String s){
        Node current=root;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(current.children[index]==null){
                return false;
            }
            current=current.children[index];
        }
        return current.eow==true;
    }

    public static boolean wordBreak(String key){

        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0, i)) &&
            wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String prefix){
        Node current =root;
        for(int i=0;i<prefix.length();i++){
            int index=prefix.charAt(i)-'a';
            if(current.children[index]==null){
                return false;
            }
            current=current.children[index];
        }
        return true;
    }
    
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static String ans="";

    public static void longestWord(Node root,StringBuilder temp){
        if(root==null){
            return;
        }

        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].eow==true){  
                temp.append((char)(i+'a'));
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);//backtracking
            }
        }
    }
    public static void main(String[] args) {
        String words[]={"a","banana","app","appl","ap","apple","apply"};
        //String s="ababa";

        // for(int i=0;i<s.length();i++){
        //     String suffix=s.substring(i);
        //     insert(suffix);
        // }
       
        //System.out.println(countNodes(root));

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
        

        // String key="ath";
        // System.out.println(wordBreak(key));
        // System.out.println(search("there"));
        // System.out.println(search("thor"));

        // System.out.println(startsWith("an"));
        // System.out.println(startsWith("ve"));

        
    }
}