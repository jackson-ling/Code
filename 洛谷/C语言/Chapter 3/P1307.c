#include<stdio.h>
int main()
{
    int n,ans=0,temp;
    scanf("%d",&n);
    if(n==0)
    {
        printf("%d",0);
    }
    if(n>0)
    {
        while(n)
        {
            //核心两行
            ans=ans*10+n%10;
            n/=10;
        }
        printf("%d",ans);
    }
    if(n<0)
    {

        //第一种处理
//        temp=-n;

        //第二种处理
        temp=n+2*(-n); //易错：这里要加负号

        while(temp)
        {
            ans=ans*10+temp%10;
            temp/=10;
        }
        printf("-%d",ans);
    }
}