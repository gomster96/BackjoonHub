#include<bits/stdc++.h>

using namespace std;

int R, C;
char mp[52][52];
bool ch[51][51];

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

struct hok{
    int r, c, dis;
    hok(int aa, int bb, int cc){
        r = aa;
        c = bb;
        dis = cc;
    }
};

int bfs(int r, int c){
    memset(ch, false, sizeof(ch));
    queue<hok> q;
    q.push(hok(r, c, 0));
    ch[r][c] = true;
    int res = 0;
    while(!q.empty()){
        
        hok ret = q.front();
        if(res < ret.dis) res = ret.dis;
        q.pop();

        for(int i=0; i<4; i++){
            int rr = ret.r+dy[i];
            int cc = ret.c+dx[i];

            if(!ch[rr][cc] && mp[rr][cc] =='L'){
                ch[rr][cc] = true;
                q.push(hok(rr,cc,ret.dis+1));
            }
        }

    }

    return res;
}


int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> R >> C;

    for(int i=1; i<=R; i++){
        for(int j=1; j<=C; j++){
            cin >> mp[i][j];
        }
    }
    int res = 0;
    for(int i=1; i<=R; i++){
        for(int j=1; j<=C; j++){
            if(mp[i][j] == 'L'){
                res = max(res,bfs(i,j));
            }
        }
    }
    cout<<res<<endl;
    return 0;
}


