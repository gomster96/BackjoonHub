#include<cstdio>
#include<vector>
#include<algorithm>

using namespace std;

int N;
vector<int> rope;
bool mySort(const int& a, const int& b){
    return a>b;
}
int main(){

    // freopen("../input.txt","rt",stdin);
    scanf("%d",&N);
    int tmp;
    for(int i=0; i<N; i++){
        scanf("%d",&tmp);
        rope.push_back(tmp);
    }
    sort(rope.begin(), rope.end(), mySort);

    
    
    int res = 0;
    int resK = 0;
    for(int i=0; i<N; i++){
        
        int w = rope[i] * (i+1);

        if(w > res){
            res = w;
        }

        /// 난 이렇게 할경우 1개만 찾고 끝난다
        // 따라서 이 코드에는 오류가 있다. 
        // if(w > res){
            
        //     res = w;
        //     resK++;
        // }
        // else break;
        
    }
    printf("%d\n",res);
    return 0;
}


