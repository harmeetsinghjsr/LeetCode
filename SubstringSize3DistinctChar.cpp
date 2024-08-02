//Without repeating characters good pairs
#include <iostream>
#include <string>
#include <map>
using namespace std;

class Solution {
public:
	int countGoodSubstrings(string s) {
		int n = s.size();
		map<string,bool>seen;
		int res = 0;
		for(int i=0; i<= n-3; i++){

			// filtered out "bad strings"
			if(s[i] == s[i+1] || s[i] == s[i+2] || s[i+1] == s[i+2])
				continue;

			// s[i], s[i+1], s[i+2] are distinct
			string good_sub = "";
			good_sub += s[i];
			good_sub += s[i+1];
			good_sub += s[i+2];

			cout << "good substring: " << good_sub << endl;

			if(seen[good_sub] == false){
				res++;
				seen[good_sub] = true;
			}
		}
		return res;
	}
};