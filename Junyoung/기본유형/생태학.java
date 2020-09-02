// https://www.acmicpc.net/problem/4358

import java.io.*;
import java.util.*;

public class Main {

    static TreeMap<String, Double> tree = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String input;
        int cnt = 0;
        while((input = br.readLine()) != null){
            if(tree.containsKey(input)){
                tree.replace(input, tree.get(input)+1);
            } else {
                tree.put(input, 1.0);
            }
            cnt++;
        }
        for(String name : tree.keySet()){
            System.out.println(name + " " + String.format("%.4f", 100*tree.get(name)/cnt));
        }
    }
}