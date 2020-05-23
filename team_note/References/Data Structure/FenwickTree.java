import java.io.*;
import java.util.*;

class FenwickTree{
    int N;
    long[] tree, num;

    public FenwickTree(int N){
        this.N = N;
        tree = new long[N+1];
        num = new long[N+1];
    }
    // *when initially adding, range of i is 1 ~ N
    void update(int i, long val){
        long diff = val-num[i];
        num[i] = val;
        while(i <= N){
            tree[i] += diff;
            i += (i & -i);
        }
    }
    long sum(int i){
        long ans = 0;
        while(i > 0){
            ans += tree[i];
            i -= (i & -i);  // 1 of last position in binary notation of i
        }
        return ans;
    }
    long sum(int s, int e){
        return sum(e) - sum(s-1);   
    }
}
