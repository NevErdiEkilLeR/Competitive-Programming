// https://www.acmicpc.net/problem/14442

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

class Pot{
    int r, c, d, b;
    public Pot(int r, int c, int d, int b){
        this.r = r; this.c = c;
        this.d = d; this.b = b;
    }
}

class Solution{
    final int[] dr = {-1,1,0,0};
    final int[] dc = {0,0,1,-1};

    boolean[][][] visit;
    Queue<Pot> q = new ArrayDeque<>();

    public Solution(int N, int M, int K, int[][] board) {
        visit = new boolean[N+2][M+2][K+1];
        q.offer(new Pot(1,1, 1, 0));
        visit[1][1][0] = true;
        while(!q.isEmpty()){
            Pot now = q.poll();
            if(now.r == N && now.c == M) {
                System.out.println(now.d);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if(nr < 1 || nc < 1 || nr > N || nc > M)    continue;
                if(board[nr][nc] == 0 && !visit[nr][nc][now.b]){
                    q.offer(new Pot(nr,nc,now.d+1, now.b));
                    visit[nr][nc][now.b] = true;
                }
                if(board[nr][nc] == 1 && now.b < K && !visit[nr][nc][now.b+1]){
                    q.offer(new Pot(nr,nc,now.d+1, now.b+1));
                    visit[nr][nc][now.b+1] = true;
                }
            }
        }
        System.out.println(-1);
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
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N+2][M+2];
        for(int r = 1; r <= N; r++){
            String line = br.readLine();
            for(int c = 1; c <= M; c++){
                board[r][c] = line.charAt(c-1)-'0';
            }
        }
        new Solution(N, M, K, board);
    }
}