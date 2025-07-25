#include<stdio.h>
//思路：在输出倒三角形的基础上输出数字，““利用累加是没想到的””
int main()
{
    int n,cnt=1;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        for(int j=n-i+1;j>=1;j--)
        {
            printf("%02d",cnt);
            cnt++;
        }
        printf("\n");
    }
}
