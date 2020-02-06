#include <cstdio>
using namespace std;

#define FOR(i,s,e) for(int i = s; i < e; i++)

typedef pair <int, int> pii;
typedef struct POT{
	int r, c, val;
}Pot;

// 북 동 남 서
const int dr[] = {-1, 0, 1, 0};
const int dc[] = {0, 1, 0, -1};

// 8방면
const int dr2[] = {-1,-1,-1,0,1,1,1,0};
const int dc2[] = {-1,0,1,1,1,0,-1,-1};

// 반시계방향 (북서 동북 남동 서남)
const int l_turn[] = {3,0,1,2};
// 시계방향 (북동 동남 남서 서북)
const int r_turn[] = {1,2,3,0};

pii operator + (const pii &a, const pii &b){	
	return pii(a.first+b.first, a.second+b.second);
}

int R, C;
void direction_check(int r, int c){
	FOR(i, 0, 4){
		int nr = r + dr[i];
		int nc = c + dc[i];
		if(nr < 0 || nr >= R || nc < 0 || nc >= C)	continue;
		// if(visited[nr][nc])	continue;
	}
}