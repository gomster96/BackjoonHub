#include<bits/stdc++.h>

using namespace std;

int N, M;

int check[100][100] = {0, };
bool v[100][100] = {false,};
string arr[100];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void BFS(int i, int j){
    v[i][j] = true;

    queue<pair<int, int> > q;
    q.push(make_pair(i, j));

    while(!q.empty()){
        int x = q.front().second;
        int y = q.front().first;

        q.pop();

        for(int k=0; k<4; k++){
            int newX = x+dx[k];
            int newY = y+dy[k];
            if(0 <= newX && newX < M && 0 <= newY && newY < N && arr[newY][newX] == '1' && !v[newY][newX] && check[newY][newX] == 0){
                check[newY][newX] = check[y][x] + 1;
                v[newY][newX] = true;
                q.push(make_pair(newY, newX));
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    int i;

    cin >> N >> M;
    for(i=0; i<N; i++) cin>> arr[i];

    BFS(0,0);
    cout<<check[N-1][M-1]+1<<endl;

    return 0;
}


