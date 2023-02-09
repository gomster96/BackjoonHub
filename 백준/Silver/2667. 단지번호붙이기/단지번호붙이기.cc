#include<bits/stdc++.h>

using namespace std;

int N;
// 충분히 잡으면 굳이 경계값 확인할 필요 없음
int mp[27][27];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int cnt = 1;
int res = 0;
void DFS(int r, int c){

    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];

        if(mp[rr][cc]==1){
            mp[rr][cc] = 0;
            DFS(rr, cc);
            cnt++;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> N;
    char tmp;
    //// char 형으로 처리한것 유의해서보기
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            cin >> tmp;
            mp[i][j] = tmp - '0';
        }
    }
    vector<int> ans;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=N; j++){
            if(mp[i][j] == 1){
                mp[i][j] = 0;
                DFS(i,j);
                res++;     
                ans.push_back(cnt);
                cnt = 1;
            } 
            
        }
    }
    cout<<res<<endl;
    /// 문제에서 단지를 오름차순으로 정리해서 출력하라고하였다.... 이런거 놓치지말자.
    sort(ans.begin(), ans.end());
    for(int i=0; i<ans.size(); i++){
        cout<<ans[i]<<endl;
    }
    return 0;
}


