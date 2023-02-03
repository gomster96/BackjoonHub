#include<bits/stdc++.h>

using namespace std;

int N;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int a[102][102];
bool ch[102][102];
int res = 1;
int standKey = 0;
void DFS(int r, int c){
    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];

        if( !ch[rr][cc] && a[rr][cc] > standKey){
            ch[rr][cc] = true;
            DFS(rr,cc);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> N;
    int myMin = 2147000000, myMax = -2147000000;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            cin >> a[i][j];
            if(a[i][j] > myMax) myMax = a[i][j];
            if(a[i][j] < myMin) myMin = a[i][j];
        }
    }
    for(standKey=myMin; standKey<=myMax; standKey++){
        memset(ch, false, sizeof(ch));
        int cnt = 0;
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if( !ch[i][j] && a[i][j] > standKey){
                    ch[i][j] = true;
                    DFS(i, j);
                    cnt++;
                }
            }
        }
        if(cnt > res) res = cnt;
    }
    cout<<res<<endl;


    return 0;
}


