// https://www.acmicpc.net/problem/1761

import java.io.*;
import java.util.*;

class Node {
    int node, dist;
    public Node(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution{
    //     BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    final int MAXN = (int)4e4 + 2;
    final int LOGN = 16+2;

    int N;
    int[] d = new int[MAXN];
    int[] dist = new int[MAXN];
    int[][] p = new int[MAXN][LOGN];
    List<List<Node>> tree = new ArrayList<>();

    public void findParent(int root){
        Queue<Node> q = new ArrayDeque<>();
        d[root] = 1;
        q.offer(new Node(root, 0));
        while(!q.isEmpty()){
            Node here = q.poll();
            for(Node next : tree.get(here.node)){
                if(d[next.node] > 0)    continue;
                dist[next.node] = dist[here.node] + next.dist;
                d[next.node] = d[here.node] + 1;
                p[next.node][0] = here.node;
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
        if(min == max)  return max;
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
            int c = Integer.parseInt(st.nextToken());
            tree.get(a).add(new Node(b,c));
            tree.get(b).add(new Node(a,c));
        }
        findParent(1);
        int M = Integer.parseInt(br.readLine());
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(dist[a]+dist[b]-2*dist[lca(a,b)]+"\n");
        }
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}