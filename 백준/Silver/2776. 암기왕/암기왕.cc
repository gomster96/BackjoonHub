#include<cstdio>
#include<vector>
#include<algorithm>
using namespace std;

int N, M, T;
vector<int> memo1;


int BinarySearch(int lt, int rt, int num){
    if(lt>rt){
        return 0;
    }
    else{
        int mid = (lt+rt)/2;
        if(memo1[mid] == num) return 1;
        else if(memo1[mid] > num){
            return BinarySearch(lt, mid-1, num);
        }
        else{
            return BinarySearch(mid+1, rt, num);
        }
    }
}

int main(){

    // freopen("../input.txt","rt",stdin);
    scanf("%d",&T);
    for(int t=0; t<T; t++){
        memo1.clear();
        scanf("%d",&N);
        int tmp = 0;
        for(int i=0; i<N; i++){
            scanf("%d",&tmp);
            memo1.push_back(tmp);
        }
        sort(memo1.begin(), memo1.end());
        scanf("%d",&M);
        for(int i=0; i<M; i++){
            scanf("%d",&tmp);
            
            if(tmp > memo1[N-1] || tmp < memo1[0]){
                printf("0\n");
            }
            else printf("%d\n",BinarySearch(0, memo1.size()-1, tmp));
        }

    }
    return 0;
}


