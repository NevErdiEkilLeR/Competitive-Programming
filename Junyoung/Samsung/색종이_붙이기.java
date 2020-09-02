// https://www.acmicpc.net/problem/17136

import java.io.*;
import java.util.*;

public class Main {
    static int [][] map = new int[10][10];
    static int [] rem = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static boolean canPaint(int r, int c, int len) {
        if(r+len > 10 || c+len > 10) return false;

        for(int rr = 0; rr < len; rr++) {
            for(int cc = 0; cc < len; cc++) {
                if(map[r+rr][c+cc] != 1) return false;
            }
        }
        return true;
    }
    public static void fill(int r, int c, int len, int state) {
        for(int rr = 0; rr < len; rr++) {
            Arrays.fill(map[r+rr], c, c+len, state);
        }
    }

    public static void dfs(int idx, int cnt) {
        if(idx == 10*10 || ans <= cnt) {
            ans = Math.min(ans, cnt);
            return;
        }
        int r = idx/10, c = idx%10;
        if(map[r][c] != 1){
            dfs(idx+1, cnt);
            return;
        }
        for(int i = 5; i > 0; i--) {
            if(rem[i] <= 0 || !canPaint(r, c, i))   continue;
            fill(r, c, i, 0);   rem[i]--;
            dfs(idx+1, cnt+1);
            fill(r, c, i, 1);   rem[i]++;
        }
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        for(int r = 0; r < 10; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < 10; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}