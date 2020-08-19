import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.acmicpc.net/problem/13398

class Solution {

    public Solution(int N, int[] seq) {;
        int[][] psum = new int[N][2];
        int max = seq[0];
        for(int n = 0; n < N; n++){
            psum[n][0] = psum[n][1] = seq[0];
            if(n == 0)  continue;
            psum[n][0] = Math.max(psum[n-1][0] + seq[n], seq[n]);
            psum[n][1] = Math.max(psum[n-1][0], psum[n-1][1] + seq[n]);
            max = Math.max(psum[n][0], Math.max(psum[n][1], max));
        }
        System.out.println(max);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++){
            seq[n] = Integer.parseInt(st.nextToken());
        }
        new Solution(N, seq);
    }
}
