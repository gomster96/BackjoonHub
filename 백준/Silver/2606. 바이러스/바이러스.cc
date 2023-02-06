#include<bits/stdc++.h>

using namespace std;

int N, M;
int a[101][101];
bool ch[101];
int cnt;
void DFS(int v){

    for(int i=2; i<=N; i++){
        if(ch[i] == false && a[v][i] == 1){
            ch[i] = true;
            DFS(i);
            cnt++;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    
    cin >> N >> M;
    int ta, tb;
    for(int i=1; i<=M; i++){
        cin >> ta >> tb;
        a[ta][tb] = 1;
        a[tb][ta] = 1;
    }
    ch[1] = true;
    DFS(1);
    cout<<cnt<<endl;
    return 0;
}


