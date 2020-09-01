// https://www.acmicpc.net/problem/5052

import java.io.*;
import java.util.*;

class Trie {
    TrieNode root = new TrieNode();

    public boolean insert(String word){
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!now.children.containsKey(ch)){
                now.children.put(ch, new TrieNode());
            }
            now = now.children.get(ch);
            if(now.isTerminal)  return true;
        }
        if(now.children.size() > 0) return true;
        now.isTerminal = true;
        return false;
    }

    static class TrieNode {
        boolean isTerminal = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean isInconsist = false;
            for(int n = 0; n < N; n++){
                String input = br.readLine();
                isInconsist = isInconsist || trie.insert(input);
            }
            System.out.println(isInconsist ? "NO" : "YES");
        }
    }
}