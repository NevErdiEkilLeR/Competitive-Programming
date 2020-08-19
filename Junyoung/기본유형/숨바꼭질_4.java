// https://www.acmicpc.net/problem/13913

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

class Solution{

    final int MAXN = 100000+1;
    int[] before = new int[MAXN];
    Queue<Integer> q = new ArrayDeque<>();

    public void go(int now, int next){
        if(next < 0 || next >= MAXN)    return;
        if(before[next] != -1) return;
        before[next] = now;
        q.offer(next);
    }

    public Solution(int N, int K) {
        Arrays.fill(before, -1);
        go(N, N);

        int now = -1;
        while(!q.isEmpty()){
            now = q.poll();
            if(now == K)    break;
            go(now, now-1);
            go(now, now+1);
            go(now, now*2);
        }
        List<Integer> route = new ArrayList<>();
        while(now != N){
            route.add(now);
            now = before[now];
        }
        route.add(now);
        System.out.println(route.size()-1);
        Collections.reverse(route);
        System.out.println(route.stream().map(i ->i+" ").collect(joining()));
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        new Solution(N, K);
    }
}