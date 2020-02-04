#include <cstdio>
#include <set>
#include <algorithm>
using namespace std;

// 솔직히 이 문제는 기억이 잘 안 난다...
// 테스트도 없이 어렴풋한 기억으로 다시 작성한 거니 참고만 하자..

typedef struct TREE{
	int x;
	TREE* l;
	TREE* r;
}tree;

set <int> s;

int solution(tree * T) {
    bool flag = false;
	int max_len = 0;
	
	if(!s.count(T->x)){
		s.insert(T->x);
		flag = true;
	}
	max_len = s.size();
	
	if(T->l != NULL)	max_len = max(max_len, solution(T->l));
	if(T->r != NULL)	max_len = max(max_len, solution(T->r));	
	if(flag)	s.erase(s.find(T->x));
	
	return max_len;
}