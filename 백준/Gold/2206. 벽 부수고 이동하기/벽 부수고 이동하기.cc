#include<stdio.h>
#include<queue>
using namespace std;

struct st{
    int x;
    int y;
    int wall;
    st(int a, int b, int c){
        x = a;
        y = b;
        wall = c;
    }
};

int map[1001][1001];
int result[1001][1001];
bool visit[1001][1001][2];

int main(){
    int N, M;
    // freopen("../input.txt","rt",stdin);
    scanf("%d %d",&N, &M);
    
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            /// scanf에서 하나만 받는 방법
            scanf("%1d",&map[i][j]);
        }
    }
    
    queue<st> q;
    q.push(st(1,1,0));
    // visit[x][y][0] 은 벽을 부수지않고 좌표 방문, visit[x][y][1]은 벽을 부수고 좌표 방문
    visit[0][0][0] = visit[0][0][1] = true;
    result[1][1] = 1;
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    while(!q.empty()){
        int x = q.front().x;
        int y = q.front().y;
        int wall = q.front().wall;
        q.pop();

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx > 0 && ny > 0 && nx <=N && ny <=M){
                // 벽이고 부순적이 없으면서 방문 안한 곳
                if(map[nx][ny] == 1 && wall == 0 && !visit[nx][ny][wall+1]){
                    visit[nx][ny][wall+1] = true;
                    result[nx][ny] = result[x][y] +1;
                    q.push(st(nx, ny, wall+1));
                }
                // 벽이 아니고 방문 안한 곳
                if(map[nx][ny] != 1 && !visit[nx][ny][wall]){
                    visit[nx][ny][wall] = true;
                    result[nx][ny] = result[x][y] +1;
                    q.push(st(nx,ny,wall));
                }
                // 목표에 도착했을 경우
                if(nx == N && ny == M){
                    printf("%d\n",result[nx][ny]);
                    return 0;
                }
            }
        }
    }
    if(N==1 && M ==1) printf("1\n");
        else printf("-1\n");
        return 0;
}

// #include<bits/stdc++.h>

// using namespace std;

// int N, M;
// int a[1002][1002];
// bool ch[1002][1002];
// int dy[4] = {-1, 0, 1, 0};
// int dx[4] = {0, 1, 0, -1};
// struct block{
//     int y, x, val;
//     block(int ta, int tb, int tc){
//         y = ta;
//         x = tb;
//         val = tc;
//     }
// };
// int BFS(){
//     memset(ch, false, sizeof(ch));
//     queue<block> q;
//     q.push(block(1,1,1));
//     ch[1][1] = true;
//     while(!q.empty()){
//         block ret = q.front();
//         q.pop();
//         for(int i=0; i<4; i++){
//             int rr = ret.y + dy[i];
//             int cc = ret.x + dx[i];
//             if(!ch[rr][cc] && a[rr][cc] == 0 ){
//                 if(rr == N && cc == M){
//                     return ret.val+1;
//                 }
//                 ch[rr][cc] = true;
//                 q.push(block(rr,cc,ret.val+1));
//             }
//         }
//     }
//     return -1;
// }

// int main(){
//     ios_base::sync_with_stdio(false);
//     // freopen("../input.txt","rt",stdin);
//     memset(a, -1, sizeof(a));
//     cin >> N >> M;
//     int res = -1;
//     char tt;
//     for(int i=1; i<=N; i++){
//         for(int j=1; j<=M; j++){
//             cin >> tt;
//             a[i][j] = tt - '0';
//         }
//     }
//     res = BFS();
//     for(int i=1; i<=N; i++){
//         for(int j=1; j<=M; j++){
//             if(a[i][j] == 1){
                
//                 a[i][j] = 0;
//                 int tmp = BFS();
//                 if(res == -1) res = tmp;
//                 else if(tmp != -1) res = min(res, tmp);    
//                 a[i][j] = 1;
//             }
//         }
//     }
//     cout<<res<<endl;
//     return 0;
// }


