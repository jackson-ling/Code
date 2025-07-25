#include<stdio.h>
int main()
{
    int n,cnt=1,cnt1=1;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            printf("%02d",cnt);
            cnt+=1;
        }
        printf("\n");
    }
    printf("\n");
    for(int i=1;i<=n;i++)
    {
        for(int j=n-i;j>=1;j--)
        {
            printf("  ");  //易错：由于是占了两位字符，要打印两个空格
        }
        for(int k=1;k<=i;k++)
        {
            printf("%02d",cnt1);
            cnt1+=1;
        }
        printf("\n");
    }
}