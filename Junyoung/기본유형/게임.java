// https://www.acmicpc.net/problem/1103

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Solution{
    final int MAXN = 50;
    final int[] dr = {-1,1,0,0};
    final int[] dc = {0,0,1,-1};

    int N, M;
    boolean found;
    boolean[][] visit = new boolean[MAXN][MAXN];
    int[][] dp = new int[MAXN][MAXN], board;

    int dfs(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= M || board[r][c] == -1) return 0;
        if(visit[r][c]){
            found = true;
            return -1;
        }
        if(dp[r][c] > 0)    return dp[r][c];

        visit[r][c] = true;
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i] * board[r][c];
            int nc = c + dc[i] * board[r][c];
            dp[r][c] = Math.max(dp[r][c], dfs(nr, nc)+1);
        }
        visit[r][c] = false;
        return dp[r][c];
    }

    public Solution(int N, int M, int[][] board) {
        this.N = N; this.M = M;
        this.board = board;
        int ans = dfs(0,0);
        System.out.println(found ? -1 : ans);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N+1][M+1];
        for(int n = 0; n < N; n++){
            String line = br.readLine();
            for(int m = 0; m < M; m++){
                int num = line.charAt(m)-'0';
                board[n][m] = num > 10 ? -1 : num;
            }
        }
        new Solution(N, M, board);
    }
}