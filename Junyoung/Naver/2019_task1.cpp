#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

const int MINVAL = 99999999;
const int cost[7][7] = {
	// 1,2,3,4,5,6
	{0,1,2,3,4,5,6},
	{0,0,1,1,1,1,2},	// 1
	{0,1,0,1,1,2,1},	// 2
	{0,1,1,0,2,1,1},	// 3
	{0,1,1,2,0,1,1},	// 4
	{0,1,2,1,1,0,1},	// 5
	{0,2,1,1,1,1,0}		// 6
};
 
int solution(vector <int> &A){
	int min_move = MINVAL;
	int len = A.size();
	
	for(int top =1; top <= 6; top++){
		int move = 0;
		for(int i = 0; i < len; i++){
			move += cost[A[i]][top];
		}
		min_move = min(min_move, move);	
	}
	return min_move;
}
 
int main() {
	// N 1~100
	int N;
	scanf("%d", &N);
	vector <int> A(N);
	for(int i = 0; i < N; i++){
		scanf("%d", &A[i]);
	}
	printf("%d\n", solution(A));
	return 0;
}