#include<bits/stdc++.h>

using namespace std;

#define mine

int N;
int a[100001];
int dp[100001];
int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> N;
    for(int i=1; i<=N; i++){
        cin >> a[i];
    }
    memset(dp, 0, sizeof(dp));
    int res = -987654321;
    for(int i=1; i<=N; i++){
        dp[i] = max(dp[i-1]+a[i], a[i]);
        res = max(dp[i], res);
    }
    cout<<res<<endl;

    return 0;
}


