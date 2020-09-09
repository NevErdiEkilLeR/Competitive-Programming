import java.io.*;
import java.util.*;

class Solution {
    final int MAXN = (int)1e5 + 2;
    final int LOGN = 20;

    int N;
    int[] d = new int[MAXN];
    int[][] p = new int[MAXN][LOGN];
    List<List<Integer>> tree = new ArrayList<>();

    public void findParent(int root){
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
        for(int ln = 1; ln < LOGN; ln++){
            for(int n = 1; n <= N; n++){
                p[n][ln] = p[p[n][ln-1]][ln-1];
            }
        }
    }

    public int lca(int a, int b){
        int min = d[a] < d[b] ? a : b;
        int max = min != a ? a : b;
        int diff = d[max] - d[min];
        for(int i = 0; diff > 0; i++){
            max = (diff & 1) > 0 ? p[max][i] : max;
            diff >>= 1;
        }
        if(max == min)  return max;
        for(int i = LOGN-1; i >= 0; i--){
            if(p[max][i] == p[min][i])  continue;
            max = p[max][i];
            min = p[min][i];
        }
        return Math.max(p[max][0], 1);
    }

    public int[] solution(int N, int[][] directory, int[][] query){
        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }
        for(int[] e : directory){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        this.N = N;
        findParent(1);

        int[] ans = new int[query.length];
        for(int i = 0; i < query.length; i++){
            int a = query[i][0], b = query[i][1];
            ans[i] = d[a] + d[b] - 2*d[lca(a,b)] + 1;
        }
        return ans;
    }
}