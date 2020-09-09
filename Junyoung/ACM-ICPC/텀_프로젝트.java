// https://www.acmicpc.net/problem/9466

import java.io.*;
import java.util.*;

class Solution {

    final int MAXN = (int)1e5+2;

    int[] s;
    boolean[] visit = new boolean[MAXN];
    Queue<Integer> cycle = new ArrayDeque<>();

    public int findCycle(int now){
        if(visit[now])    return 0;
        visit[now] = true;
        cycle.offer(now);

        int next = s[now];
        if(visit[next]){
            while(!cycle.isEmpty()){
                if(cycle.peek() == next)    break;
                cycle.poll();
            }
            return cycle.size();
        }
        return removeCycle(next);
    }

    public int solution(int N, int[] s){
        int ans = 0;
        this.s = s;
        for(int i = 1; i <= N; i++){
            cycle.clear();
            ans += removeCycle(i);
        }
        return N-ans;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] s = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int n = 1; n <= N; n++){
                s[n] = Integer.parseInt(st.nextToken());
            }
            System.out.println(new Solution().solution(N, s));
        }
    }
}