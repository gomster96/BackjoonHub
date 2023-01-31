#include<bits/stdc++.h>

using namespace std;

#define mine

int N;
long long dp[91];
long long pinaryNumber(int n){
    if(n == 1) return 1;
    if(n == 2) return 1;
    long long& ret = dp[n];
    if(ret != -1) return ret;
    return ret = pinaryNumber(n-1) + pinaryNumber(n-2);
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    memset(dp, -1, sizeof(dp));
    cin >> N;
    
    cout << pinaryNumber(N) << endl;
    

    return 0;
}


