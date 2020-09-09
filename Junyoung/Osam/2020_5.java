import java.io.*;
import java.util.*;

class Solution {
    final int MAXN = (int)2e5+1;

    boolean[] visit = new boolean[MAXN];
    HashSet<Integer> cycle = new HashSet<>();
    HashSet<Integer> cycleEntry = new HashSet<>();
    List<HashSet<Integer>> lock = new ArrayList<>();

    public void findCycle(int now){
        for(int next : lock.get(now)){
            if(visit[next])  continue;
            visit[next] = true;
            if(cycle.contains(next)){
                cycleEntry.add(next);
                continue;
            }
            cycle.add(next);
            findCycle(next);
            cycle.remove(next);
        }
    }

    public int solution(int N, int[][] res){
        List<Integer> pq = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            lock.add(new HashSet<>());
            pq.add(i);
        }
        for(int[] v : res){
            lock.get(v[0]).add(v[1]);
        }

        pq.sort((a, b) -> lock.get(b).size() - lock.get(a).size());
        for(int idx : pq){
            cycle.add(idx);
            findCycle(idx);
            visit[idx] = true;
            cycle.remove(idx);
        }
        return N-cycleEntry.size();
    }
}