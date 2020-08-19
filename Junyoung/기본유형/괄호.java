// https://www.acmicpc.net/problem/10422

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
    final int MAXL = 5000;
    final long MOD = (long) (1e9+7);

    long[] dp = new long[MAXL+1];

    long dnc(int L){
        if(L == 0)  return 1;
        if(dp[L] >= 0)   return dp[L];
        dp[L] = 0;
        for(int i = 2; i <= L; i+=2){
            dp[L] += dnc(i-2)*dnc(L-i);
            dp[L] %= MOD;
        }
        return dp[L];
    }

    public Solution(int T, int[] tc) {
        Arrays.fill(dp, -1);
        dnc(MAXL);
        for(int t = 0; t < T; t++){
            int L = tc[t];
            System.out.println(L%2==1 ? 0 : dp[L]);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] tc = new int[T];
        for(int t = 0; t < T; t++){
            tc[t] = Integer.parseInt(br.readLine());
        }
        new Solution(T, tc);
    }
}
