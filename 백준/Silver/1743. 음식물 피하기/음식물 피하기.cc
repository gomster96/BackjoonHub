#include<bits/stdc++.h>

using namespace std;

int N, M, K;

int a[102][102];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

int DFS(int r, int c){
    int ret = 1;
    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];
        if(a[rr][cc] == 1){
            a[rr][cc] = 0;
            ret += DFS(rr,cc);
        }
    }
    
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> N >> M >> K;
    int ta, tb;
    for(int i=1; i<=K; i++){
        cin >> ta >> tb;
        a[ta][tb] = 1;
    }
    int res = 0;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            if(a[i][j] == 1){
                a[i][j] = 0;
                res = max(res, DFS(i,j));
            }
        }
    }
    cout << res <<endl;
    return 0;
}


