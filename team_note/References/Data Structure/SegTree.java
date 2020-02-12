class SegTree {
    private long[] tree;    // root node : 1

    public SegTree(int N){
        int h = (int)Math.ceil(Math.log(N)/Math.log(2));    // log2(N)
        tree = new long[1 << (h+1)];
    }
    public long init(long[] num, int node, int s, int e){
        if(s == e)  return tree[node] = num[s];
        int m = (s+e)/2;
        return tree[node] = init(num, node*2, s, m)
                + init(num, node*2+1, m+1, e);
    }
    // node's range: s~e & sum range: sumL~sumR
    public long sum(int node, int s, int e, int sumL, int sumR){
        if(e < sumL || sumR < s)    return 0;
        if(sumL <= s && e <= sumR)  return tree[node];
        int m = (s+e)/2;
        return sum(node*2, s, m, sumL, sumR)
                + sum(node*2+1, m+1, e, sumL, sumR);
    }
    public long update(int node, int s, int e, int idx, long diff){
        if(idx < s || idx > e)  return tree[node];
        if(s == e)  return tree[node] = diff;
        int m = (s+e)/2;
        return tree[node] = update(node*2, s, m, idx, diff)
                + update(node*2+1, m+1, e, idx, diff);
    }
}