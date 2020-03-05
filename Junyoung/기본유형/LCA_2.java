// https://www.acmicpc.net/problem/11438

import java.io.*;
import java.util.*;

class Solution{
    //    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    final int MAXN = (int)1e5 + 2;
    final int LOGN = 20;

    int N;
    int[] d = new int[MAXN];
    int[][] p = new int[MAXN][LOGN];
    List<List<Integer>> tree = new ArrayList<>();

    // O(N*lgN)
    public void findParent(int root){
        // O(N)
        Queue<Integer> q = new ArrayDeque<>();
        d[root] = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int here = q.poll();
            for(int next : tree.get(here)){
                if(d[next] > 0) continue;
                p[next][0] = here;
                d[next] = d[here]+1;
                q.offer(next);
            }
        }
        // O(N*lgN)
        for(int ln = 1; ln < LOGN; ln++){
            for(int n = 1; n <= N; n++){
                p[n][ln] = p[p[n][ln-1]][ln-1];
            }
        }
    }
    // O(lgN)
    public int lca(int a, int b){
        int min = d[a] < d[b] ? a : b;
        int max = min != a ? a : b;
        int diff = d[max] - d[min];
        // bit operation (up to same depth)
        for(int i = 0; diff > 0; i++){
            max = (diff & 1) > 0 ? p[max][i] : max;
            diff >>= 1;
        }
        if(max == min)  return max;
        // from root to parent
        for(int i = LOGN-1; i >= 0; i--){
            if(p[max][i] == p[min][i])  continue;
            max = p[max][i];
            min = p[min][i];
        }
        return Math.max(p[max][0], 1);
    }
    public Solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++)
            tree.add(new ArrayList<>());
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        findParent(1);
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