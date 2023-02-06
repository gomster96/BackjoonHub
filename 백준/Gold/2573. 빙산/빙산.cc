#include<bits/stdc++.h>

using namespace std;

int R, C;
int a[302][302];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int year = 0;
int landCnt = 0;
bool ch[302][302];
bool flag = false;
int afterYearMinus[302][302];
void afterOneYear(){
    memset(afterYearMinus, 0, sizeof(afterYearMinus));
    for(int i=1; i<=R; i++){
        for(int j=1; j<=C; j++){
            if(a[i][j] > 0){
                
                for(int k=0; k<4; k++){
                    int ii = i+dy[k];
                    int jj = j+dx[k];
                    if(a[ii][jj] == 0) afterYearMinus[i][j]++;
                }
            }
        }
    }
    for(int i=1; i<=R; i++){
        for(int j=1; j<=C; j++){
            a[i][j] = a[i][j] - afterYearMinus[i][j];
            if(a[i][j] < 0) a[i][j] = 0;
        }
    }
    year++;
}

void DFS(int r, int c){

    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];

        if(a[rr][cc] > 0 && ch[rr][cc] == false){
            ch[rr][cc] = true;
            DFS(rr,cc);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    cin >> R >> C;
    memset(a, -1, sizeof(a));
    for(int i=1; i<=R; i++){
        for(int j=1; j<=C; j++){
            cin >> a[i][j];
        }
    }

    while(1){
        if(flag == true || landCnt > 1) break;
        
        
        memset(ch, false, sizeof(ch));
        afterOneYear();
        flag = true;
        landCnt = 0;
        
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(a[i][j] > 0 && !ch[i][j]){
                    
                    ch[i][j] = true;
                    flag = false;            
                    DFS(i,j);
                    landCnt++;
                }
            }
        }
    }

    if(flag == true) cout << 0 << '\n';
    else cout << year << '\n';
    return 0;
}


