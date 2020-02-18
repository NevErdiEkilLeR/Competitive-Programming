// https://www.acmicpc.net/problem/1790

import java.io.*;
import java.util.*;

class Solution {
//    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//    BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N, K;
    int digitLen;
    long digitCnt;
    long curNum;
    long rem;

    public Solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        digitLen = 1;
        digitCnt = 9;
        curNum = 0;
        rem = K;

        solve();
        bw.close();
    }

    public void solve() throws IOException {
        while(rem > digitLen*digitCnt){
            curNum += digitCnt;
            rem -= digitCnt*digitLen;
            digitCnt *= 10;
            digitLen++;
        }
        curNum += rem/digitLen + (rem%digitLen > 0 ? 1 : 0);
        int idx = (int)((rem-1)%digitLen);

        if(curNum > N){
            bw.write(-1+"\n");
            return;
        }
        bw.write(Long.toString(curNum).charAt(idx)+"\n");
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
    }
}