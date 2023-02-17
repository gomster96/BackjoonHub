#include<bits/stdc++.h>

using namespace std;

int R, C;
char a[252][252];
int wCnt =0, sCnt=0;
int wCntTotal =0, sCntTotal=0;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void DFS(int r, int c){
    
    if(a[r][c] == 'v') wCnt++;
    else if(a[r][c] == 'o') sCnt++;
    a[r][c] = '#';

    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];

        if(a[rr][cc] != '#'){
            DFS(rr,cc);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    memset(a, '#', sizeof(a));
    cin >> R >> C;
    for(int i=1; i<=R; i++){
        for(int j=1; j<=C; j++){
            cin >> a[i][j];
        }
    }

    for(int i=1; i<=R; i++){
        for(int j=1; j<=C; j++){
            if(a[i][j] != '#'){
                DFS(i,j);
                if(wCnt >= sCnt) sCnt = 0;
                else if(wCnt < sCnt) wCnt = 0;
                wCntTotal += wCnt;
                sCntTotal += sCnt;
                wCnt = sCnt = 0;
            }
        }
    }
    cout<<sCntTotal << " "<< wCntTotal<<'\n';
    return 0;
}


