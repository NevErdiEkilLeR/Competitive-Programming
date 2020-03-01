import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int idx, dist;
    public Node(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
    public int compareTo(Node o){
        return dist-o.dist;
    }
}

// O(E*log(V))
class Dijkstra {
    final int MAXV = (int) 2e4+2;

    int[] minDist = new int[MAXV];
    List<List<Node>> graph = new ArrayList<>();

    public int getDist(int A, int B) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        minDist[A] = 0;
        pq.offer(new Node(A, minDist[A]));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist > minDist[cur.idx]) continue;

            for (Node next : graph.get(cur.idx)) {
                int compDist = minDist[cur.idx] + next.dist;
                if (minDist[next.idx] > compDist) {
                    minDist[next.idx] = compDist;
                    pq.offer(new Node(next.idx, next.dist));
                }
            }
        }
        return minDist[B] < Integer.MAX_VALUE ? minDist[B] : -1;
    }
    public void add(int u, int v, int w){
        graph.get(u).add(new Node(v, w));
    }
    public Dijkstra(){
        Arrays.fill(minDist, 0, MAXV, Integer.MAX_VALUE);
    }
}
