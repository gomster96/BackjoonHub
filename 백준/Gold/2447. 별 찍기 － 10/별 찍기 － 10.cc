#include<bits/stdc++.h>
using namespace std;

#define mine

#ifdef mine
int mp[2500][2500];

void fillStar(int size, int row, int col){

    if(size == 3){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j == 1){
                    continue;
                }
                else{
                    mp[row+i][col+j] = 1;
                }
            }
        }
    }
    else{
        fillStar(size/3, row, col);
        fillStar(size/3, row, col+size/3);
        fillStar(size/3, row, col+(size/3)*2);
        fillStar(size/3, row+size/3, col);

        fillStar(size/3, row+size/3, col+(size/3)*2);
        fillStar(size/3, row+(size/3)*2, col);
        fillStar(size/3, row+(size/3)*2, col+size/3);
        fillStar(size/3, row+(size/3)*2, col+(size/3)*2);
    }

}

int main(){
    ios_base::sync_with_stdio(false);
    
    

    int n = 0;    
    cin>>n;
    fillStar(n, 0, 0);
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(mp[i][j] == 1) cout<<'*';
            else cout<<" ";
        }
        cout<<'\n';
    }
    
    
    return 0;
}

#endif
#ifdef other
int main(){
    ios_base::sync_with_stdio(false);
    freopen("input.txt","rt",stdin);
    time_t timeStart, timeEnd;
    timeStart = time(NULL);

    timeEnd = time(NULL);
    cout << "execute time: "<<(double)(timeEnd - timeStart) << endl;
    return 0;
}
#endif