// https://www.acmicpc.net/problem/1520

#include <stdio.h>
#include <string.h>

using namespace std;

const int MAX_N = 500 + 1;
int dr[] = { 1,-1,0,0 };
int dc[] = { 0,0,1,-1 };

int M, N;
int map[MAX_N][MAX_N];
int dp[MAX_N][MAX_N];

int dfs(int r, int c) {
	if ((r == M) && (c == N))	return 1;
	if((r < 1 || r > M || c < 1 || c > N))	return 0;
	if (dp[r][c] != -1)	return dp[r][c];

	dp[r][c] = 0;
	for (int i = 0; i < 4; i++) {
		int nr = r + dr[i];
		int nc = c + dc[i];
		if (map[nr][nc] < map[r][c]) {
			dp[r][c] += dfs(nr, nc);
		}
	}
	return dp[r][c];
}

int main() {
	scanf("%d %d", &M, &N);
	for (int i = 1; i <= M; i++) {
		for (int j = 1; j <= N; j++) {
			scanf("%d", &map[i][j]);
		}
	}
	memset(dp, -1, sizeof(dp));
	printf("%d", dfs(1, 1));
	return 0;
}