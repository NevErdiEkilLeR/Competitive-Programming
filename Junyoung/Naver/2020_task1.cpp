#include <cstdio>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

#define FOR(i,s,e) for(int i = s; i < e; i++)

int N;
vector<bool> selected;
vector<string> B;

int dfs(int idx, bool sel) {
	if (idx == N) {
		vector<bool> hash(26, false);

		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if (!selected[i])	continue;
			for(int s = 0, sz = B[i].size(); s < sz; s++) {
				if (hash[i]) {
					return 0;
				}
				hash[i] = true;
				cnt++;
			}
		}
		return cnt;
	}
	selected[idx] = sel;
	return max(dfs(idx+1, true), dfs(idx+1, false));
}

int solution(vector<string> &A) {
	for(int i = 0, len = A.size() ; i < len; i++) {
		vector<bool> hash(26, false);
		for(int s = 0, sz=A[i].size(); s < sz; s++) {
			if (hash[s]) {
				A.erase(A.begin() + i);
				break;
			}
			hash[s] = true;
		}
	}
	N = A.size();
	B = A;
	return max(dfs(0, true), dfs(0, false));
}
