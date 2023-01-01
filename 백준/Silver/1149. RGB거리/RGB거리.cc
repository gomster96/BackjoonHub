#include<bits/stdc++.h>
using namespace std;

const int RED = 0;
const int GREEN = 1;
const int BLUE = 2;
int color[3] = {RED, GREEN, BLUE};
int N;
int a[3][1001];
int cache[3][1001];

int findRGB(int n, int currentColor){
    if(n > N) return 0;
    
    int&ret = cache[currentColor][n];
    if(ret != -1) return ret;
    ret = 987654321;

    for(int i=0; i<3; i++){
        if(i!= currentColor){
            ret = min(ret, a[currentColor][n]+findRGB(n+1, i));
        } 
    }
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
   

    memset(a, -1, sizeof(a));
    memset(cache, -1, sizeof(cache));

    cin >> N;
    for(int i=1; i<=N; i++){
        cin >> a[RED][i] >> a[GREEN][i] >> a[BLUE][i];
    }
    
    cout << min(findRGB(1, RED), min(findRGB(1, GREEN), findRGB(1, BLUE))) << endl;;

    
    return 0;
}


