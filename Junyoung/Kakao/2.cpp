// 

#include <cstdio>
#include <cstring>
#include <string>
#include <queue>
#include <map>
#include <algorithm>
#include <vector>
using namespace std;

#define FOR(i,s,e) for(int i = s; i < e; i++)
#define FORr(i,e,s) for(int i = e; i >= s; i--)
#define ALL(x) (x).begin(), (x).end()
typedef long long ll;
typedef pair <int, int> pii;
typedef pair <string, string> pss;

const int MAXN = 8 + 2;
const int MAXM = 10;

bool comp(string u, string b) {
	int len = b.size();
	if(u.size() != len)	return false;
	FOR(i, 0, len) {
		if (b[i] == '*')	continue;
		if (u[i] != b[i])	return false;
	}
	return true;
}

int solution(vector<string> user, vector<string> ban) {
	vector<pss> ub_map;
	vector<string> candid;

	int ulen = user.size();	int blen = ban.size();
	FOR(b, 0, blen)	FOR(u, 0, ulen) {
		if (comp(user[u], ban[b])) {
			string apx = to_string(b);
			ub_map.push_back({ ban[b]+apx, user[u] });
		}
	}
	printf("%d", ub_map.size());

	
	
	
	
	
	int ret = 1;
	return ret;
}

int main() {
	int N, M;
	vector<string> user;
	vector<string> ban;

	scanf("%d %d ", &N, &M);

	char input[MAXN];
	FOR(i, 0, N) {
		fgets(input, MAXM, stdin);
		input[strlen(input)-1] = NULL;
		user.push_back(input);
	}
	FOR(i, 0, M) {
		fgets(input, MAXM, stdin);
		input[strlen(input) - 1] = NULL;
		ban.push_back(input);
	}
	printf("%d\n", solution(user, ban));
	
	return 0;
}