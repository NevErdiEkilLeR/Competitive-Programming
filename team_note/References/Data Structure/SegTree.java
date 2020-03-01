class SegTree {
    private long[] tree;    // root node : 1

    public SegTree(long[] num){
        int h = (int)Math.ceil(Math.log(num.length)/Math.log(2));    // log2(N)
        tree = new long[1 << (h+1)];
        init(num, 1, 0, num.length-1);
    }
    public long init(long[] num, int node, int s, int e){
        if(s == e)  return tree[node] = num[s];
        int m = (s+e)/2;
        return tree[node] = init(num, node*2, s, m)
                + init(num, node*2+1, m+1, e);
    }
    // [node's range]: s~e & [sum range]: sumL~sumR
    public long sum(int node, int s, int e, int sumL, int sumR){
        if(e < sumL || sumR < s)    return 0;
        if(sumL <= s && e <= sumR)  return tree[node];
        int m = (s+e)/2;
        return sum(node*2, s, m, sumL, sumR)
                + sum(node*2+1, m+1, e, sumL, sumR);
    }
    public long update(int node, int s, int e, int idx, long val){
        if(idx < s || idx > e)  return tree[node];
        if(s == e)  return tree[node] = val;
        int m = (s+e)/2;
        return tree[node] = update(node*2, s, m, idx, val)
                + update(node*2+1, m+1, e, idx, val);
    }
}
