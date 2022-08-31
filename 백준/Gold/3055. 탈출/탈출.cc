#include<bits/stdc++.h>

using namespace std;

int R, C;
char mp[52][52];
bool ch[53][53];
bool addWater[52][52];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
struct gosem{
    int r, c, val;
    gosem(int aa, int bb, int cc){
        r = aa;
        c = bb;
        val = cc;
    }
};

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    cin >> R >> C;
    int r, c;
    memset(mp, 'Q', sizeof(mp));
    memset(ch, false, sizeof(ch));
    for(int i=1; i<=R; i++){
        for(int j=1; j<=C; j++){
            cin >> mp[i][j];
            if(mp[i][j] == 'S'){
                r = i;
                c = j;
            }
        }
    }
    queue<gosem> q;
    q.push(gosem(r, c, 0));
    ch[r][c] = true; 
    mp[r][c] = '.';
    int val = 0;

    while(!q.empty()){

        gosem ret = q.front();
        q.pop();
        
        memset(addWater, false, sizeof(addWater));

        if(val == ret.val){
            for(int i=1; i<=R; i++){
                for(int j=1; j<=C; j++){
                    if(mp[i][j] == '*'){
                        for(int k=0; k<4; k++){
                            int ii = i+dy[k];
                            int jj = j+dx[k];
                            
                            if(mp[ii][jj] == '.') addWater[ii][jj] = true;
                        }
                    }
                }
            }

            for(int i=1; i<=R; i++){
                for(int j=1; j<=C; j++){
                    if(addWater[i][j] == true){
                        mp[i][j] = '*';
                    }
                }
            }
            val++;
        }

        

        // for(int i=1; i<=R; i++){
        //     for(int j=1; j<=C; j++){
        //         if(i == ret.r && j == ret.c) cout<<"S";
        //         else cout<<mp[i][j];
        //     }
        //     cout<<endl;
        // }

        for(int i=0; i<4; i++){
            int rr = ret.r + dy[i];
            int cc = ret.c + dx[i];
            
            if(mp[rr][cc] == 'D'){
                
                cout << ret.val+1 << endl;
                return 0;
            }

            if(!ch[rr][cc] && mp[rr][cc] == '.'){
                ch[rr][cc] = true;
                q.push(gosem(rr, cc, ret.val+1));
            }
        }

    }
    
    cout<<"KAKTUS"<<endl;
    
    return 0;
}


