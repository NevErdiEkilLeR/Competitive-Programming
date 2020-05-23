// https://www.acmicpc.net/problem/11437

import java.io.*;
import java.util.*;

class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    final int MAXN = (int)5e4 + 2;

    int N;
    List<List<Integer>> tree = new ArrayList<>();
    int[] p = new int[MAXN];
    int[] d = new int[MAXN];

    public void makeTree(int root){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);
        p[root] = 1;
        d[root] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : tree.get(cur)){
                if(p[next] > 0) continue;
                q.offer(next);
                p[next] = cur;
                d[next] = d[cur] + 1;
            }
        }
    }
    public int lca(int a, int b){
        int min = d[a] < d[b] ? a : b;
        int max = min != a ? a : b;
        while(d[min] != d[max]){
            max = p[max];
        }
        while(min != max){
            min = p[min];
            max = p[max];
        }
        return min;
    }
    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }
        while(--N > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        makeTree(1);
        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(lca(a, b)+"\n");
        }
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}