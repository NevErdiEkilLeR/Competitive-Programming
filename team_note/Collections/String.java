#include <cstdio>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

const int MAXLEN = 10000 + 2;

vector<int> get_num() {
	vector<int> out;
	int token;
	while (scanf("%1d", &token) != EOF)	out.push_back(token);
	return out;
}

// faster than getline
string str_in() {
	char input[MAXLEN];
	fgets(input, MAXLEN, stdin);
	input[strlen(input)-1] = '\0';
	return (string)input;
}

vector<string> split(string in, char delim) {
	vector <string> out;
	stringstream ss(in);
	string token;
	while (getline(ss, token, delim))	out.push_back(token);
	return out;
}

int main(){
	// substr
	string a = "nice_to_meet_you";
	// nice_to_meet_you
	string a1 = a.substr();
	// to_meet_you
	string a2 = a.substr(5);
	// e_to_
	string a3 = a.substr(3, 5);
}