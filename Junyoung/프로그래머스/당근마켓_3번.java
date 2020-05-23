import java.io.*;
import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.IntStream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        String input;

        final int MAXN = (int)1e6+2;
        int[][] arr = new int[MAXN][2];
        int idx = 0, totalSp = Integer.parseInt(br.readLine());
        while((input = br.readLine()) != null){
            st = new StringTokenizer(input);
            arr[idx][0] = Integer.parseInt(st.nextToken());
            arr[idx++][1] = Integer.parseInt(st.nextToken());
        }
        new Solution(totalSp, copyOfRange(arr, 0, idx));
    }
}

class Solution {
    int root = 1, sum = 0;
    int[] score;
    List<List<Integer>> child = new ArrayList<>();

    public int dfs(int node){
        score[node] = child.get(node).isEmpty() ? 1 :
                child.get(node).stream().mapToInt(this::dfs).sum();
        sum += score[node];
        return score[node];
    }

    public Solution(int totalSp, int[][] skills){
        int N = skills.length+2;
        score = new int[N];
        for(int i = 0; i < N; i++){
            child.add(new ArrayList<>());
        }
        // make tree
        int[] p = new int[N];
        for(int[] skill : skills){
            p[skill[1]] = skill[0];
            child.get(skill[0]).add(skill[1]);
        }
        while(p[root] != 0) root = p[root];
        // traverse
        score[root] = dfs(root);
        range(1, N).mapToObj(i -> score[i]*totalSp/sum+" ")
                .forEach(System.out::print);
    }
}