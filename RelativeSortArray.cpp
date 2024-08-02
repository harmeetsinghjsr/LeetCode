#include <bits/stdc++.h>
#include <vector>
class Solution {

public:

vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {

map<int, int>mp; // freq of elements in arr1

for(int element: arr1){

mp[element]++;

}

 

// key --> i

// value --> mp[i]

 

vector<int>res;

for(int element: arr2){

int freq = mp[element];

while(freq--){

res.push_back(element);

}

mp[element] = 0;

}

 

auto it = mp.begin();

while(it != mp.end()){

int freq = it->second;

int element = it->first;

while(freq--){

res.push_back(element);

}

it++;

}

return res;

}

};