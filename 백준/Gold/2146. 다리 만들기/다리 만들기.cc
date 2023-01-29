#include<bits/stdc++.h>

using namespace std;

int N;
int mp[102][102];
bool ch[102][102];
int territoryCnt = 0;
int territoryColor = 2;
int territoryStart = 2;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
struct road{
    int r, c, dis;
    road(int aa, int bb, int cc){
        r = aa;
        c = bb;
        dis = cc;
    }
};

void findTerritory(int r, int c, int color){
    
    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];
        if(!ch[rr][cc] && mp[rr][cc] == 1){
            ch[rr][cc] = true;
            mp[rr][cc] = color;
            findTerritory(rr,cc,color);
        }
    }
}

int findRoadLength(int r, int c, int color){
    queue<road> q;
    q.push(road(r,c,0));
    ch[r][c] = true;
    while(!q.empty()){
        road ret = q.front();
        q.pop();

        for(int i=0; i<4; i++){
            int rr = ret.r+dy[i];
            int cc = ret.c+dx[i];
            if(!ch[rr][cc] && mp[rr][cc] != 0 && mp[rr][cc] != color){
                return ret.dis;
            }
            else if(!ch[rr][cc] && mp[rr][cc] == 0 && rr > 0 && rr <= N && cc > 0 && cc<=N){
                ch[rr][cc] =true;
                q.push(road(rr,cc,ret.dis+1));
            }
        }
    }
    return 2147000000;
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    cin >> N ;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            cin >> mp[i][j];
        }
    }
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            if(mp[i][j] == 1){
                memset(ch, false, sizeof(ch));
                ch[i][j] = true;
                mp[i][j] = territoryColor;
                findTerritory(i, j, territoryColor);
                territoryColor++;
                territoryCnt++;
            }
        }
    }
    int res = 2147000000;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            if(mp[i][j] != 0){
                memset(ch, false, sizeof(ch));
                res = min(res,findRoadLength(i, j, mp[i][j]));
            }
        }
    }
    cout<<res<<endl;
    return 0;
}


