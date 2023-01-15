#include<bits/stdc++.h>

using namespace std;

int N, M;
int a[502][502];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int area = 0;
int cnt = 0;

void DFS(int r, int c){
    area++;
    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];

        if(a[rr][cc] == 1){
            a[rr][cc] = 0;
            DFS(rr,cc);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> N >> M;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            cin >> a[i][j];
        }
    }
    int  maxArea = 0;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            if(a[i][j] == 1){
                cnt++;
                area = 0;
                a[i][j] = 0;
                DFS(i,j);
                if(area > maxArea) maxArea = area;
            }
        }
    }
    cout<<cnt<<endl;
    cout<<maxArea<<endl;
    return 0;
}


