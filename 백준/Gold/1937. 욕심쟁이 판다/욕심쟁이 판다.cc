#include<bits/stdc++.h>

using namespace std;

int N;
int a[502][502];
int dp[502][502];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

int DFS(int r, int c){
    int& ret = dp[r][c];
    if(ret != -1) return ret;
    ret = 1;
    // int ret = sum;

    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];
        if(a[rr][cc] > a[r][c]){
            ret = max(ret, DFS(rr,cc)+1);
        }
    }

    return ret;
}


int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    memset(dp, -1, sizeof(dp));
    cin >> N;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            cin >> a[i][j];
        }
    }

    int res = 0;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            res = max(res, DFS(i,j));
        }
    }
    cout << res << endl;
    return 0;
}


