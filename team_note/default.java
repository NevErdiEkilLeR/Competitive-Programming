package project;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }
}

class Solution {
    int N, M;
    
    public Solution() throws IOException {        
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        
        // StringTokenizer ??
    }
    
    public void solve(){
        System.out.println(N+" "+M);
    }
}