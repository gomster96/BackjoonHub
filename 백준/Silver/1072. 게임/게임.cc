#include<cstdio>
#include<algorithm>
#include<vector>

using namespace std;

long long X, Y, Z;

bool isChange(long long win, long long total){
    /// 여기서 win*100 하는 순간 오버플로우가 나올 수 있음 이런거 까지 생각해야함
    long long val = (win*100)/total;
    if(val > Z) return true;
    else return false;
}
int res = 2147000000;
int BinarySearch(long long lt, long long rt){
    if(lt> rt){
        return res;
    }
    else{
        long long mid = (lt+rt)/2;
        if(isChange(Y+mid, X+mid)){
            if(mid < res) res = mid;
            return BinarySearch(lt, mid-1);
        }
        else{
            return BinarySearch(mid+1, rt);
        }
    }
}

int main(){

    // freopen("../input.txt","rt",stdin);
    
    scanf("%lld %lld",&X, &Y);
    Z = (Y*100)/X;
    int ret = BinarySearch(1, X);
    if(ret == 2147000000) printf("-1\n");
    else printf("%d\n",ret);
    return 0;
}


