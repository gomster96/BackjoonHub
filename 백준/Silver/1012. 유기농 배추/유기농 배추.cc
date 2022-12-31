#include<bits/stdc++.h>

using namespace std;

int M, N, K, T;
int mp[52][52];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
void DFS(int r, int c){
    for(int i=0; i<4; i++){
        int rr = r + dy[i];
        int cc = c + dx[i];

        if(mp[rr][cc] == 1){
            mp[rr][cc] = 0;
            DFS(rr,cc);
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> T;
    for(int t =0; t<T; t++){
        memset(mp, 0, sizeof(mp));
        cin >> M >> N >> K;
        int ta, tb;
        for(int i=1; i<=K; i++){
            cin >>ta >> tb;
            //// 0도 들어오니 나는 1부터 시작하고 싶기때문에 이렇게 체크해줘야함.
            //// 실수 2 : x가 먼저들어오는지, y가 먼저들어오는지 제대로확인하기.
            mp[tb+1][ta+1] = 1;
        }
        int cnt = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                
                if(mp[i][j] == 1){
                    
                    mp[i][j] = 0;
                    DFS(i, j);
                    cnt++;
                }
            }
        }
        cout<<cnt<< endl;
    }
    
    return 0;
}


