// https://www.acmicpc.net/problem/2042

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}

class Solution {
    //    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    final int MAXN = 100+2;

    int N, M, K;
    SegTree sqt;

    public Solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[] num = new long[N];
        for (int n = 0; n < N; n++){
            num[n] = Long.parseLong(br.readLine());
        }
        sqt = new SegTree(N);
        sqt.init(num, 1, 0, N-1);

        for (int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1){
                sqt.update(1, 0, N-1, b-1, c);
            } else {
                bw.write(sqt.sum(1, 0, N-1, b-1, (int)c-1)+"\n");
            }
        }
        bw.close();
    }
}

class SegTree {
    private long[] tree;    // root node : 1

    public SegTree(int N){
        int h = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new long[1 << (h+1)];
    }
    public long init(long[] num, int node, int s, int e){
        if(s == e)  return tree[node] = num[s];
        int m = (s+e)/2;
        return tree[node] = init(num, node*2, s, m)
                + init(num, node*2+1, m+1, e);
    }
    // node's range: s~e & sum range: sumL~sumR
    public long sum(int node, int s, int e, int sumL, int sumR){
        if(e < sumL || sumR < s)    return 0;
        if(sumL <= s && e <= sumR)  return tree[node];
        int m = (s+e)/2;
        return sum(node*2, s, m, sumL, sumR)
                + sum(node*2+1, m+1, e, sumL, sumR);
    }
    public long update(int node, int s, int e, int idx, long diff){
        if(idx < s || idx > e)  return tree[node];
        if(s == e)  return tree[node] = diff;
        int m = (s+e)/2;
        return tree[node] = update(node*2, s, m, idx, diff)
                + update(node*2+1, m+1, e, idx, diff);
    }
}