// https://www.acmicpc.net/problem/15988

#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

#define FOR(i,s,e) for(int i = s; i < e; i++)
#define FORr(i,e,s) for(int i = e; i >= s; i--)
#define ALL(x) (x).begin(), (x).end()
typedef long long ll;

const int MAXN = 1e6+2;
const int MOD = 1e9+9;

ll dp[MAXN];
ll solve(int N){
	if(dp[N])	return dp[N];
	if(N < 4)	return dp[N];
	return dp[N] = (solve(N-1)+solve(N-2)+solve(N-3))%MOD;
}

int main(){
	dp[0] = 0;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	
	int T;
	scanf("%d", &T);
	FOR(t, 0, T){
		int N;
		scanf("%d", &N);
		printf("%lld\n", solve(N));
	}
	return 0;
}