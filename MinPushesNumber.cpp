#include <vector>
#include <string>
#include <algorithm>
using namespace std;

//Leetcode problem: 3016. Minimum Number of Pushes to Type Word II
//Link: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/
class Solution {
public:
    int minimumPushes(string word) {
        
        //Generic solution
        vector<int> mp(26, 0);
        for(char &ch: word)
            mp[ch - 'a']++; //Mentioned in qn, all letters will be distinct
    
        sort(begin(mp), end(mp), greater<int>()); //descending order of frequency
        
        int ans = 0;
        for(int i = 0; i < 26; i++){
            ans += mp[i]*((i/8) + 1);
        }
        return ans;
    }
};
int main() {
    // TODO: Add test cases
    return 0;
}
