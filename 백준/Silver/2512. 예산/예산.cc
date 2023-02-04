#include<cstdio>
#include<algorithm>
#include<vector>
using namespace std;

vector<int> budget;
int N, M;
long long findBudget(int val){
    long long sum = 0;
    for(int i=0; i<budget.size(); i++){
        if(budget[i] < val){
            sum += budget[i];
        }
        else sum += val;
    }
    return sum;
}
int res = 0;
int BinarySearch(int lt, int rt){
    if(lt > rt){
        return res;
    }
    else{
        int mid = (lt+rt) / 2;
        long long midVal = findBudget(mid);

        if(midVal <= M){
            res = max(res, mid);
            return BinarySearch(mid+1, rt);
        }
        else{
            return BinarySearch(lt, mid-1);
        }
    }
}

int main(){

    // freopen("../input.txt","rt",stdin);
    
    scanf("%d",&N);
    int tmp, mm = 0;
    for(int i=0; i<N; i++){
        scanf("%d",&tmp);
        if(tmp > mm) mm = tmp;
        budget.push_back(tmp);
    }

    scanf("%d",&M);
    printf("%d\n", BinarySearch(1, mm));

    return 0;
}


