package project;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}

class Solution {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    final int MAXN = 100+2;

    int N;

    public Solution() throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            solve();
        }
        bw.close();
    }

    public void solve() throws IOException {
        bw.write(N+"\n");
    }
}
