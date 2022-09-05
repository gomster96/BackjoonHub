#include<bits/stdc++.h>

using namespace std;

#define mine



int a[1001];
int cache[1001];
int N;

int incSeq(int start){
    if(start > N) return 0;
    int& ret = cache[start];
    if(ret != -1) return ret;
    ret = 1;
    for(int i=start+1; i<=N; i++){
        if(a[start] < a[i]){
            ret = max(ret, incSeq(i)+1);
        }
    }
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    // freopen("../input.txt","rt",stdin);
    memset(cache, -1, sizeof(cache));
    cin >> N;
    for(int i=1; i<=N; i++){
        cin >> a[i];
    }
    int res = 0;
    for(int i=1; i<=N; i++){
        res = max(incSeq(i), res);
    }

    cout << res << endl;

    return 0;
}


