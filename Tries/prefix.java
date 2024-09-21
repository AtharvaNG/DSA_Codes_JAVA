import java.util.*;
public class prefix {

    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int frequency;

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            frequency=1;
        }

    }

    static Node root =new Node();

    public static void insert(String s){
        Node current =root;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(current.children[index]==null){
                current.children[index]=new Node();
            }
            else{
                current.children[index].frequency++;
            }
            current=current.children[index];
        }
        current.eow=true;
    }

    public static void findPrefix(Node root,String ans){
        if(root==null){
            return;
        }
        if(root.frequency==1){
            System.out.println(ans);
            return ;
        }
        for(int i=0;i<root.children.length;i++){
            if(root.children[i]!=null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String arr[]={"zebra","dog","duck","dove"};

        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        root.frequency=-1;

        findPrefix(root, "");

    }
}
