#include<bits/stdc++.h>

using namespace std;

struct Data{
    int a, b, c;
    Data(int x, int y, int z){
        a =x;
        b = y;
        c = z;
    }
};

int A, B, C;
bool chk[202][202], ans[202];

void bfs(){
    queue<Data> q;
    q.push(Data(0,0,C));

    while(!q.empty()){
        Data now = q.front();
        q.pop();

        if(chk[now.a][now.b]) continue;

        chk[now.a][now.b] = true;

        if(now.a == 0) ans[now.c] = true;

        //a -> b
        if(now.a + now.b > B) q.push(Data(now.a+now.b-B, B, now.c));
        else q.push(Data(0, now.a+now.b, now.c));
        //a->c
        if(now.a + now.c > C) q.push(Data(now.a+now.b - C, now.b, C));
        else q.push(Data(0, now.b, now.a+now.c));
        //b->a
        if(now.b + now.a > A) q.push(Data(A, now.b+now.a - A, now.c));
        else q.push(Data(now.b+now.a, 0, now.c));
        //b->c
        if(now.b + now.c  > C) q.push(Data(now.a, (now.b+now.c)-C, C));
        else q.push(Data(now.a, 0, now.b+now.c));
        //c->a
        if(now.c + now.a > A) q.push(Data(A, now.b, now.c+now.a - A));
        else q.push(Data(now.c + now.a, now.b, 0));
        //c->b
        if(now.c + now.b > B) q.push(Data(now.a, B, now.c + now.b - B));
        else q.push(Data(now.a, now.c+now.b, 0));
    }
}
void print(){
    for(int i=0; i<=C; i++){
        if(ans[i]) printf("%d ",i);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    cin >> A >> B >> C;
    bfs();
    print();
    return 0;
}


