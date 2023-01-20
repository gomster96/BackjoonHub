#include<bits/stdc++.h>

using namespace std;

int R, C;
char a[22][22];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
bool ch[26];
int res = 1, cnt = 1;
const int upperA = 65;
void DFS(int r, int c){
    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];
        if( !ch[a[rr][cc]-upperA] && (a[rr][cc] >= upperA)){
            ch[a[rr][cc]-upperA] = true;
            cnt++;
            DFS(rr, cc);
            if(cnt > res) res = cnt;
            ch[a[rr][cc]-upperA] = false;
            cnt--;            
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> R >> C;
    for(int i = 1; i<=R; i++){
        for(int j=1; j<=C; j++){
            cin >> a[i][j];
        }
    }
    memset(ch, false, sizeof(ch));
    ch[a[1][1]-upperA] = true;
    DFS(1, 1);
    // cout<<(int)'A'<<endl; // 65
    // cout<<0 - upperA << endl;
    cout<<res<<endl;
    return 0;
}


