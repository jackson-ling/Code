#include<stdio.h>

int main()
{
    int n,x,a=0;
    scanf("%d%d",&n,&x);
    for(int i=1;i<=n;i++)
    {
        int temp=i,cnt;
        while(temp)
        {
            cnt=temp%10;
            temp/=10;
            //这个if应该放在里面，每次取出一位数字后就做一个判断
            if(cnt==x)
            {
                a+=1;
            }
        }
    }
    printf("%d",a);
}