// https://www.acmicpc.net/problem/11658

import java.io.*;
import java.util.*;

class FenwickTree2D{
    int N;
    int[][] tree;

    public FenwickTree2D(int N){
        this.N = N;
        tree = new int[N+1][N+1];
    }
    public void update(int r, int c, int val){
        int diff = val-sum(r, c, r, c);
        while(r <= N){
            int nc = c;
            while(nc <= N){
                tree[r][nc] += diff;
                nc += (nc & -nc);
            }
            r += (r & -r);
        }
    }
    public int sum(int r, int c){
        int ans = 0;
        while(r > 0){
            int nc = c;
            while(nc > 0){
                ans += tree[r][nc];
                nc -= (nc & -nc);
            }
            r -= (r & -r);
        }
        return ans;
    }
    public int sum(int r1, int c1, int r2, int c2){
        return sum(r2, c2)
            -sum(r1-1, c2)
            -sum(r2, c1-1)
            +sum(r1-1, c1-1);
    }
}

class Solution{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N, M;
    FenwickTree2D ft;

    public Solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ft = new FenwickTree2D(N);
        for(int r = 1; r <= N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++){
                ft.update(r, c, Integer.parseInt(st.nextToken()));
            }
        }
        
        for(int r = 1; r <= N; r++){
            for(int c = 1; c <= N; c++){
                bw.write(ft.tree[r][c]+" ");
            }
            bw.newLine();
        }
        bw.newLine();
        
        for(int i = 0; i < M; i++){
            List<Integer> num = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                num.add(Integer.parseInt(st.nextToken()));
            }
            if(num.get(0) == 0){
                ft.update(num.get(1), num.get(2), num.get(3));
            } else {
                int psum = ft.sum(num.get(1), num.get(2), num.get(3), num.get(4));
                bw.write(psum+"\n");
            }
        }
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}