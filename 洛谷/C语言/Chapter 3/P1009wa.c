#include<stdio.h>
//精度不够，需要学习高精度处理
int factorial(int x)
{
    if(x==1)
    {
        return 1;
    }
    return x* factorial(x-1);
}

int main()
{
    long long n,sum=0;
    scanf("%lld",&n);
    for(int i=1;i<=n;i++)
    {
        sum+=factorial(i);
    }
    printf("%lld",sum);
}

