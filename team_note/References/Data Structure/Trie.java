import java.io.*;
import java.util.*;

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            now = now.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        now.isTerminal = true;
    }

    public boolean contains(String word){
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++){
            TrieNode next = now.children.get(word.charAt(i));
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