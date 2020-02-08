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

    final int MAXN = 100;
    final long MAXK = (long) 1e9;

    int N, M, K;
    long[][] cnt = new long[MAXN+2][MAXN+2]; // cnt[a][z] = aHz
    StringBuilder ans = new StringBuilder("");

    public Solution() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        solve();
    }

    public void makeWord(int a, int z, long kth){
        if(a == 0){
            ans.append("z".repeat(Math.max(0, z)));
            return;
        }
        if(z == 0){
            ans.append("a".repeat(Math.max(0, a)));
            return;
        }
        // z...za...a
        if(cnt[a-1][z] >= kth){
            ans.append("a");
            makeWord(a-1, z, kth);
        } else {
            ans.append("z");
            makeWord(a, z-1, kth-cnt[a-1][z]);
        }
    }

    public void solve() throws IOException {
        cnt[1][1] = 2;
        for(int a = 0; a <= MAXN; a++){
            for(int z = 0; z <= MAXN; z++){
                if(a == 0 || z == 0){
                    cnt[a][z] = 1;
                    continue;
                }
                cnt[a+1][z] = Math.min(cnt[a][z]*(a+z+1)/(a+1), MAXK);
                cnt[a][z+1] = Math.min(cnt[a][z]*(a+z+1)/(z+1), MAXK);
            }
        }
        if(cnt[N][M] < K){
            System.out.println(-1);
            return;
        }
        makeWord(N, M, K);
        System.out.println(ans.toString());
    }
}