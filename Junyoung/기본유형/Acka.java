// https://www.acmicpc.net/problem/12996

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    final static int MAXS = 51;
    final static int mod = (int)1e9+7;

    static int[][][][] dp;

    public static int dfs(int s, int d, int k, int h){
        if(d < 0 || k < 0 || h < 0) return 0;
        if(dp[s][d][k][h] > -1)  return dp[s][d][k][h];
        if(s == 0){
            dp[s][d][k][h] = (d == 0 && k == 0 && h == 0) ? 1 : 0;
            return dp[s][d][k][h];
        }
        if(s > d+k+h || s < d || s < k || s < h){
            dp[s][d][k][h] = 0;
            return dp[s][d][k][h];
        }

        int ret = 0;
        ret = (ret+dfs(s-1, d-1, k, h))%mod;
        ret = (ret+dfs(s-1, d, k-1, h))%mod;
        ret = (ret+dfs(s-1, d, k, h-1))%mod;
        ret = (ret+dfs(s-1, d-1, k-1, h))%mod;
        ret = (ret+dfs(s-1, d-1, k, h-1))%mod;
        ret = (ret+dfs(s-1, d, k-1, h-1))%mod;
        ret = (ret+dfs(s-1, d-1, k-1, h-1))%mod;
        dp[s][d][k][h] = ret;
        return dp[s][d][k][h];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        dp = new int[S+1][D+1][K+1][H+1];
        for(int[][][] d3 : dp){
            for(int[][] d2 : d3){
                for(int[] d1 : d2){
                    Arrays.fill(d1, -1);
                }
            }
        }
        System.out.println(dfs(S, D, K, H));
    }
}