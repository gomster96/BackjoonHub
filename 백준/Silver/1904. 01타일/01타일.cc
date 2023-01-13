#include<bits/stdc++.h>

using namespace std;


int N;
int dp[1000001];
const int MOD = 15746;
int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> N;

    dp[1] = 1;
    dp[2] = 2;
    for(int i=3; i<=N; i++){
        dp[i] = (dp[i-1] + dp[i-2])%MOD;
    }
    cout << dp[N] << endl;
    return 0;
}


