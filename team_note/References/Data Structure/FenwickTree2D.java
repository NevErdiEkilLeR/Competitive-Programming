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