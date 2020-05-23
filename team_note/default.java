import java.io.*;
import java.util.*;

class Solution {
//    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//    BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    // long range: 1e18 + a / 1<<63 -1
    // int range: 1e9 + a / 1<<31-1

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

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution();
        makeTest();
        compare();
    }
    public static void makeTest() throws IOException {
        final int cnt = 3000;
        final int MAXN = 100000000;
        final int MAXK = 400;
        Random random = new Random();
        BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"));
        for(int i = 0; i < cnt; i++){
            int N = random.nextInt(MAXN)+1;
            int K = random.nextInt(MAXK)+1;
            bw.write(N+" "+K+"\n");
        }
        bw.close();
    }
    public static void compare() throws IOException {
        BufferedWriter comp = new BufferedWriter(new FileWriter("compare.txt"));

        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        BufferedReader out1 = new BufferedReader(new FileReader("output.txt"));
        BufferedReader out2 = new BufferedReader(new FileReader("output2.txt"));

        for(int i = 0; i < 57; i++){
            String inS = in.readLine();
            String outS = out1.readLine();
            String out2S = out2.readLine();
            if(!outS.equals(out2S)){
                comp.write(inS+"\n");
            }
        }
        comp.close();
    }
}
