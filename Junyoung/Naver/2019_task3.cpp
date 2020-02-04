#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;
 
const int MAXVALUE = 1500000000;
const int MINVALUE = -1500000000;
typedef struct NODE{
	int lmax;
	int rmin;
}Node;
 
vector <Node> dp;
 
int solution(vector <int> &A){
	int len = A.size();
	dp.resize(len);
	
	int lmax = MINVALUE;
	int rmin = MAXVALUE;
	for(int i = 0; i < len; i++){
		lmax = max(lmax, A[i]);
		dp[i].lmax = lmax;
	}
	for(int i = len-1; i >= 0; i--){
		rmin = min(rmin, A[i]);
		dp[i].rmin = rmin;
	}
	
	for(int i = 0; i < len-1; i++){
		if(dp[i].lmax < dp[i+1].rmin)	return i+1;
	}
	return len;
}
 
int main() {
	// N 2~300,000
	int N;
	scanf("%d", &N);
	vector <int> A(N);
	for(int i = 0; i < N; i++){
		scanf("%d", &A[i]);
	}
	printf("%d\n", solution(A));
	return 0;
}
 
// 겨울 짧게
// 5, -2, 3, 8, 6
// 3
// 3까지
// -5, -5, -5, -42, 6, 12
// 4
// -42까지
// 1,000,000,000