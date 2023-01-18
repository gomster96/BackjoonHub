#include<cstdio>
#include<vector>
#include<utility>
#include<algorithm>
using namespace std;

int T, N;

bool ccomp(const pair<int, int>& a, const pair<int, int>& b){
    return a.first<b.first;
}

int main(){

    // freopen("../input.txt","rt",stdin);
    scanf("%d",&T);
    vector<pair<int, int> > people;
    for(int t=0; t<T; t++){
        scanf("%d",&N);
        people.clear();
        int ta, tb;
        
        for(int i=0; i<N; i++){
            scanf("%d %d",&ta, &tb);
            people.push_back(make_pair(ta,tb));
        }
        sort(people.begin(), people.end(), ccomp);

        int bound = people[0].second;
        int cnt = 0;
        for(int i=1; i<N; i++){
            if(people[i].second > bound){
                cnt++;
            }
            else bound = people[i].second;
        }
        printf("%d\n",N-cnt);
        // 이렇게 짠 코드의 반례
        // 만약 1 4, 4 1, 2 2, 3 3 이 있을경우 3, 3 은 탈락이다 왜냐하면 2, 2 가 있기 때문이다. 
        // 집중해서 반례찾는것에 더 연습해야겠다. 
        // int aTopB = 0, bTopA = 0;
        // for(int i=0; i<N; i++){
        //     scanf("%d %d",&ta, &tb);
        //     if(ta == 1) aTopB = tb;
        //     if(tb == 1) bTopA = ta;
        //     people.push_back(make_pair(ta, tb));
        // }
        // int cnt = 0;
        // for(int i=0; i<N; i++){
        //     if(people[i].first > bTopA || people[i].second > aTopB) cnt++;
        // }
        // printf("%d\n",N-cnt);
    }
    return 0;
}


