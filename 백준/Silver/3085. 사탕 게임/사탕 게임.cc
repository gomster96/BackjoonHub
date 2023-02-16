#include<bits/stdc++.h>
using namespace std;

#define mine

#ifdef mine

int n = 0;
char mp[51][51];
int res = -2147000000;
int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, 1, -1};

int getCnt(int r, int c,int direction){
    int rr = r+dy[direction];
    int cc = c+dx[direction];
    
    if(rr>n || cc>n || rr == 0 || cc == 0){
        return 0;
    }
    else{
        if(mp[r][c] == mp[rr][cc]){
            return 1 + getCnt(rr,cc, direction);
            
        }
    }
    return 0;
}

void check(int r, int c){
    int tmp = 0;
    for(int i=0; i<2; i++){
        tmp+= getCnt(r, c, i);
    }
    if(tmp>res) res = tmp;
    tmp  = 0;
    for(int i=2; i<4; i++){
        tmp+= getCnt(r, c, i);
    }
    if(tmp>res) res = tmp;
}

int main(){

    cin >> n;

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            cin >> mp[i][j];
        }
    }

    for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
            for(int k=0; k<4; k++){
                int ii = i+dy[k];
                int jj = j+dx[k];
                swap(mp[i][j],mp[ii][jj]);
                
                check(i, j);    
                swap(mp[i][j],mp[ii][jj]);
                
            }
            
        }
    }
    cout<<res+1<<endl;

    
    return 0;
}

#endif
#ifdef other
int main(){
    ios_base::sync_with_stdio(false);
    freopen("input.txt","rt",stdin);
    time_t timeStart, timeEnd;
    timeStart = time(NULL);

    timeEnd = time(NULL);
    cout << "execute time: "<<(double)(timeEnd - timeStart) << endl;
    return 0;
}
#endif