#include<bits/stdc++.h>
using namespace std;

#define instructor

#ifdef mine

struct bBall{
    int n, strike, ball;
    bBall(int a, int b, int c){
        n = a;
        strike = b;
        ball = c;
    }
    bool operator<<(const bBall &k) const{
        if(strike > k.strike) return strike > k.strike;
        return ball > k.ball;
    }
};

int main(){
    ios_base::sync_with_stdio(false);
    freopen("input.txt","rt",stdin);
    int c = 0;
    cin >> c;
    int n, strike, ball;
    vector<bBall> bSet;
    for(int k=0; k<c; k++){
        cin >> n >> strike >> ball;
        bSet.push_back(bBall(n, strike, ball));
    }
    sort(bSet.begin(), bSet.end());
    for(int i=0; i<bSet.size(); i++){

    }
    
    return 0;
}

#endif
#ifdef instructor

int N;
int game[988];
int num;
int s, b;
int result;

int getS(int num, int cmp){
    int strike = 0;
    if((num/100) == (cmp/100)) strike++;
    if((num%100 /10) == (cmp%100 / 10)) strike++;
    if(num%10 == cmp%10) strike++;
    return strike;
}

int getB(int num, int cmp){
    int ball = 0;
    int firstA = num/100, firstB = cmp/100;
    int secondA = num%100/10, secondB = cmp%100/10;
    int thirdA = num%10, thirdB = cmp % 10;

    if(firstA == secondB || firstA == thirdB) ball++;
    if(secondA == firstB || secondA == thirdB) ball++;
    if(thirdA == firstB || thirdA == secondB) ball++;

    return ball;
}

int main(){
    ios_base::sync_with_stdio(false);
    
    cin >> N;

    for(int i=123; i<=987; i++){
        int i1 = i/100;
        int i2 = i%100 / 10;
        int i3 = i%10;

        if(i2 == 0 || i3 == 0 || i1 == i2 || i1 == i3 || i2 == i3) game[i] = 0;
        else game[i] = i;
    }

    for(int i=0; i<N; i++)
    {
        cin >> num >> s >> b;
        for(int x = 123; x<=987; x++){
            if(!game[x]) continue;

            int cs = getS(x,num);
            int cb = getB(x,num);

            if(!((cs == s) && (cb == b))) game[x] = 0;
        }
    }

    for(int i=123; i<=987; i++){
        if(game[i]) result++;
    }
    cout<<result;

    return 0;
}
#endif