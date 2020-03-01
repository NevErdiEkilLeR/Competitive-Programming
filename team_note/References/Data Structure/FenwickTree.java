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
    long sum(int i){
        long ans = 0;
        while(i > 0){
            ans += tree[i];
            i -= (i & -i);
        }
        return ans;
    }
    // when initially adding, range of i is 1 ~ N
    void update(int i, long newVal){
        long diff = newVal-num[i];
        num[i] = newVal;
        while(i <= N){
            tree[i] += diff;
            i += (i & -i);
        }
    }
}
