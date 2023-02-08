#include<bits/stdc++.h>

using namespace std;

int N, M;
int a[102][102];
int adjustA[101][101];
int ch[102][102] = {false,};
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void findInterior(int r, int c, int value){
    for(int i=0; i<4; i++){
        int rr = r+dy[i];
        int cc = c+dx[i];
        if(ch[rr][cc] == 0 && a[rr][cc] == 0){
            ch[rr][cc] = value;
            findInterior(rr,cc, value);
        }
    }
}

int afterHour(){
    memset(adjustA, 0, sizeof(adjustA));
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            if(a[i][j] == 1){
                int cnt = 0;
                for(int k=0; k<4; k++){

                    int ii = i+dy[k];
                    int jj = j+dx[k];

                    if(a[ii][jj] == 0 && ch[ii][jj]==-1) cnt++;
                }
                if(cnt>=2) adjustA[i][j] = 1;
            }
        }
    }
    int res = 0;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            a[i][j] = a[i][j] - adjustA[i][j];
            res += a[i][j];
        }
    }
    return res;
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    memset(a, -1, sizeof(a));
    cin >> N >> M;
    for(int i=1; i<=N; i++){
        for(int j=1; j<=M; j++){
            cin >>a[i][j];
        }
    }
    int result = 1;
    while(1){
        
        memset(ch, 0, sizeof(ch));
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(a[i][j] == 0){
                    
                    if((i==1 && j == 1) || (i==N && j==1) || (i==1 && j==M) || (i==N && j==M)){
                        findInterior(i,j, -1);
                    }
                    else{
                        findInterior(i,j, 1);
                    } 
                }
                
            }
        }
        if(afterHour() == 0) break;
        result++;
    }
    cout<<result<<endl;

    return 0;
}


