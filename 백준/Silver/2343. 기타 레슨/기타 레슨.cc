#include<cstdio>
#include<algorithm>
#include<vector>
using namespace std;

vector<int> lesson;
int N, M;

int countOfBluelay(long long val){
    int cnt = 1;
    long long valSum = 0;
    for(int i=0; i<lesson.size(); i++){
        if(lesson[i] > val) return 2147000000;
        if(valSum + lesson[i] > val){
            valSum = 0;
            cnt++;
        }
        valSum += lesson[i];
    }
    return cnt;
}
int res = 2147000000;
int BinarySearch(long long lt, long long rt){
    if(lt>rt){
        return res;
    }
    else{
        long long mid = (lt+rt)/2;
        int midVal = countOfBluelay(mid);

        if(midVal <= M){
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
    
    scanf("%d %d",&N, &M);
    int tmp;
    long long m = 0;
    for(int i=0; i<N; i++){
        scanf("%d",&tmp);
        m += tmp;
        lesson.push_back(tmp);
    }
    printf("%d\n",BinarySearch(1, m));
    return 0;
}


