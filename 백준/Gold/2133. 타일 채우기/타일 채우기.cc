#include<bits/stdc++.h>

using namespace std;

int N;
int dp[31];

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    

    dp[0] = 1;
    dp[2] = 3;

    cin >> N;
    for(int i=4; i<=N; i++){
        dp[i] = dp[i-2] * 3;
        for(int j=4; j<=i; j+=2){
            dp[i] += dp[i-j] * 2;
        }
    }
    cout<<dp[N]<<endl;
    return 0;
}


