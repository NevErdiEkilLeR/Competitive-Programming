// 연습 119

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int mod = 1000+5;
    static int H, W, N;
    static int[][] map;
    static int[][] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[H+1][W+1];
            cnt = new int[H+1][W+1];
            for(int r = 0; r < H; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < W; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            // flip
            cnt[0][0] = N;
            for(int r = 0; r < H; r++){
                for(int c = 0; c < W; c++){
                    cnt[r+1][c] += cnt[r][c]/2 + (map[r][c] == 0 ? cnt[r][c]%2 : 0);
                    cnt[r][c+1] += cnt[r][c]/2 + (map[r][c] == 1 ? cnt[r][c]%2 : 0);
                }
            }
            for(int r = 0; r < H; r++){
                for(int c = 0; c < W; c++){
                    map[r][c] = (cnt[r][c]%2 == 1) ? map[r][c] : 1-map[r][c];
                }
            }
            // traverse
            int r = 0, c = 0;
            while(r < H && c < W){
                int now = map[r][c];
                r += (now == 0 ? 1 : 0);
                c += (now == 1 ? 1 : 0);
            }
            System.out.println("Case #"+t+"\n"+(r+1)+" "+(c+1));
        }
    }
}