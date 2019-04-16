// https://www.acmicpc.net/problem/2293

#include <stdio.h>

using namespace std;

int coin[10000 + 1];
int cnt[10000 + 1];	// 2���� �迭 ��� �� �޸� �ʰ�

int main() {
	int N, K;
	
	scanf("%d %d", &N, &K);
	for (int i = 1; i <= N; i++) {
		scanf("%d", &coin[i]);
	}

	cnt[0] = 1;	// ���� 1���� ���� �����ϴ� ���
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= K; j++) {
			if (j >= coin[i]) {
                cnt[j] += cnt[j-coin[i]];
            }
		}
	}
	printf("%d", cnt[K]);
	return 0;
}