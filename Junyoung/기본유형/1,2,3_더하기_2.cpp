// https://www.acmicpc.net/problem/9095

#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
#include <climits>

using namespace std;

#define FOR(i,s,e) for(int i = s; i < e; i++)
#define FORr(i,e,s) for(int i = e; i >= s; i--)
#define ALL(x) (x).begin(), (x).end()
typedef long long ll;

const int MAXN = 2e9 +2;

int N, K;
int cnt = 0;
bool flag = false;
int cache[MAXN];

void dfs(int idx, int sum){
	if(flag || sum > N)	return;
	if(sum == N){
		cnt++;
		if(cnt == K){
			flag = true;
			FOR(i, 0, idx)
				printf("%d+", cache[i]);
			printf("%d\n", cache[idx]);
		}
		return;
	}
	FOR(i, 1, 4){
		cache[idx+1] = i;
		dfs(idx+1, sum+i);
	}
}

int main(){
	scanf("%d %d", &N, &K);
	dfs(-1, 0);
	if(!flag)	printf("-1\n");
	return 0;
}