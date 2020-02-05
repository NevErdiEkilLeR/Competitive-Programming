#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;

#define FOR(i,s,e) for(int i = s; i < e; i++)

typedef long long ll;
const ll MOD = 1e9 + 7;
const int MAX_PRIME = 1e4 +2;

// find prime
bool not_prime[MAX_PRIME];

void find_prime() {
	not_prime[0] = not_prime[1] = true;
	for (int i = 2; i <= MAX_PRIME; i++) {
		if (not_prime[i])
			continue;
		for (int j = i * 2; j <= MAX_PRIME; j += i) {
			not_prime[j] = true;
		}
	}
}


ll GCD(ll a, ll b) {
	return b ? GCD(b, a%b) : a;
}
ll LCM(ll a, ll b) {
	if (a == 0 || b == 0)	return a + b;
	return a * (b / GCD(a, b));
}

// Fastpower & Moduler Operation (A^B mod C)
ll fast_power(ll base, ll power){
	ll ret = 1;
	// A^B mod C = ((A^(B/2) mod C) * (A^(B/2) mod C)) mod C
	while(power){
		if(power%2)	ret = ret * base % MOD;
		base = (base%MOD * base%MOD) % MOD;	// pow
		power /= 2;
	}
	return ret;
}

void rotate90(vector<vector<int>> &orgin){
	int N = orgin.size();
	int M = orgin[0].size();
	vector<vector<int>> temp;
	
	temp = vector<vector<int>> (N, vector<int>(M));
	FOR(r, 0, N)	FOR(c, 0, M){
		temp[r][c] = orgin[r][c];
	}
	orgin = vector<vector<int>> (M, vector<int>(N));
	FOR(r, 0, N)	FOR(c, 0, M){
		orgin[c][N-1-r] = temp[r][c];
	}
}
void rotate270(vector<vector<int>> &orgin){
	int N = orgin.size();
	int M = orgin[0].size();
	vector<vector<int>> temp;
	
	temp = vector<vector<int>> (N, vector<int>(M));
	FOR(r, 0, N)	FOR(c, 0, M){
		temp[r][c] = orgin[r][c];
	}
	orgin = vector<vector<int>> (M, vector<int>(N));
	FOR(r, 0, N)	FOR(c, 0, M){
		orgin[N-1-c][r] = temp[r][c];
	}
}
void flip_col(vector<vector<int>> &orgin){
	int N = orgin.size();
	FOR(r, 0, N){
		reverse(orgin[r].begin(), orgin[r].end());
	}
}
void flip_row(vector<vector<int>> &orgin){
	int N = orgin.size();
	int M = orgin[0].size();
	FOR(c, 0, M)	FOR(r, 0, N){
		int temp = orgin[r][c];
		orgin[r][c] = orgin[N-1-r][c];
		orgin[N-1-r][c] = temp;
	}
}

