import java.io.*;
import java.util.*;

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode now = root;
        for(char ch : word.toCharArray()){
            now = now.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        now.isTerminal = true;
    }

    public boolean contains(String word){
        TrieNode now = root;
        for(char ch : word.toCharArray()){
            TrieNode next = now.children.get(ch);
            if(next == null)    return false;
            now = next;
        }
        return now.isTerminal;
    }

    static class TrieNode {
        boolean isTerminal;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}