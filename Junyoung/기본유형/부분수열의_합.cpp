// https://www.acmicpc.net/problem/1182

#include <cstdio>
#include <vector>
using namespace std;

#define FOR(i,s,e) for(int i = s; i < e; i++)
const int MAXN = 20+2;

int N, S;
int seq[MAXN];

int dfs(int idx, int psum){
	if(idx == N)	return (psum == S);
	
	int ret = 0;
	ret += dfs(idx+1, psum + seq[idx]);
	ret += dfs(idx+1, psum);
	return ret;
}

int main(){
	scanf("%d %d", &N, &S);
	FOR(i, 0, N)	scanf("%d", &seq[i]);
	
	printf("%d\n", dfs(0,0)-(S==0));
	return 0;
}