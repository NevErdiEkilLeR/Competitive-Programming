// https://www.acmicpc.net/problem/2003

#include <bits/stdc++.h>
using namespace std;

#define FOR(i, s, e) for (int i = s; i < e; i++)
#define FORr(i, e, s) for (int i = e; i >= s; i--)
#define FORo(i, e, o) for (int i = 0, e = o.size(); i < e; i++)
#define ALL(x) (x).begin(), (x).end()
typedef long long ll;
typedef pair<int, int> pii;
typedef priority_queue<int> pqi;

using namespace std;

int N, M;
int idx = 0, psum = 0, cnt = 0;
vector<int> A;

int main(){
  scanf("%d %d", &N, &M);

  FOR(i, 0, N){
    int num;
    scanf("%d", &num);
    A.push_back(num);
    psum += A[i];

    while (psum > M)
      psum -= A[idx++];
    cnt += (psum == M);
  }
  printf("%d\n", cnt);

  return 0;
}
