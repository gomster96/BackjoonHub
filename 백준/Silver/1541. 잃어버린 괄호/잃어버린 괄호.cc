#include<cstdio>
#include<string>

using namespace std;



int main(){

    // freopen("../input.txt","rt",stdin);
    char s[52];
    scanf("%s",s);

    int res = 0;
    int tmpSum = 0;
    int minusFlag = 1;
    for(int i=0; s[i]!='\0'; i++){

        if(s[i] == '-'){

            res += tmpSum * minusFlag;
            tmpSum = 0;
            minusFlag = -1;
        }
        else if(s[i] == '+'){
            res += tmpSum * minusFlag;
            tmpSum = 0;
        }
        else{
            tmpSum = tmpSum*10 + (s[i]-'0');
            
        }

    }
    res += tmpSum * minusFlag;
    printf("%d\n",res);
    
    return 0;
}


