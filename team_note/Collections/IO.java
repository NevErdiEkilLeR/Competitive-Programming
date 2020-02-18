import java.io.*;
import java.util.*;

class Solution {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    final int MAXN = 100+2;

    public void input1() throws IOException {
        // int[N][M]
        int N, M;
        int[][] board = new int[MAXN][MAXN];

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < M; c++){
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public void input2() throws IOException {
        // int[N][M] with no space
        int N, M;
        int[][] board = new int[MAXN][MAXN];

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int r = 0; r < N; r++){
            String line = br.readLine();
            for(int c = 0; c < M; c++){
                board[r][c] = line.charAt(c)-'0';
            }
        }
    }
    public void input3() throws IOException {
        // char[N][M]
        int N, M;
        char[][] board = new char[MAXN][MAXN];

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int r = 0; r < N; r++){
            String line = br.readLine();
            for(int c = 0; c < M; c++){
                board[r][c] = line.charAt(c);
            }
        }
    }
    public void input4() throws IOException {
        // String[N]
        int N;
        String[] line = new String[MAXN];

        N = Integer.parseInt(br.readLine());
        for(int r = 0; r < N; r++){
            line[r] = br.readLine();
        }
    }
    void input5() throws IOException {
        // String tokens
        String [] token = new String[MAXN];

        token = br.readLine().split(" ");
    }
}