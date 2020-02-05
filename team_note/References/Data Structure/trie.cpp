#include <cstdio>
#include <cstring>
using namespace std;

struct Trie {
	bool finish;
	Trie* next[26];
	
	Trie() : finish(false) {
		memset(next, 0, sizeof(next));
	}
	~Trie(){
		for(int i = 0; i < 26; i++)
			if(next[i])	delete next[i];
	}
	
	void insert(const char* key){
		if (*key == '\0'){
			finish = true;
			return;
		}
		int idx = *key - 'A';
		if (next[idx] == NULL)
			next[idx] = new Trie();
		next[idx]->insert(key+1);
	}
	
	bool search(const char* key){
		// 검색 문장의 끝 도달
		if (*key == '\0')	return finish;
		int idx = *key - 'A';
		// Trie leaf 이후
		if(next[idx] == NULL)	return false;
		return next[idx]->search(key+1);
	}
};

int main(){    
	Trie* root = new Trie();
	root->insert("abc");
	root->insert("abcd");
	
	printf("0 %d\n", root->search("ab"));
	printf("1 %d\n", root->search("abc"));
	printf("1 %d\n", root->search("abcd"));
	printf("0 %d\n", root->search("abcde"));
	
    return 0;
}