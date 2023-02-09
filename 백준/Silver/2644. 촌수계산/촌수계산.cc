#include<bits/stdc++.h>

using namespace std;

int N, M;
int p1, p2;
int a[101][101];
bool ch[101] = {false, };
int res = 2147000000;

void DFS(int L,int v){
    if(v == p2){
        if(L < res) res = L;
        return;
    }
    for(int i=1; i<=N; i++){
        if(!ch[i] && a[v][i] == 1){
            ch[i] = true;
            DFS(L+1, i);
            ch[i] = false;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> N;
    cin >> p1>> p2;
    cin >> M;
    int ta, tb;
    for(int i=1; i<=M; i++){
        cin >> ta >> tb;
        a[ta][tb] = 1;
        a[tb][ta] = 1;
    }
    ch[p1] = true;
    DFS(0, p1);
    /// 아무것도 없을때를 못봄....
    if(res == 2147000000) cout<<-1<<endl;
    else cout<<res<<endl;    

    return 0;
}


