#include<stdio.h>
int main()
{
    int a[1000]={0};
    int n,count=0;  //使用变量记录元素个数
    scanf("%d",&n);
    int i=0;
    while(n!=1&&i<=999)  //加上条件约数，防止数组越界
    {
        a[i]=n;
        if(n%2!=0)
        {
            n=n*3+1;
        }
        else
        {
            n/=2;
        }
        i++;
        count++;
    }
    a[i]=1;
    count++;

    for(int i=count-1;i>=0;i--)
    {
        printf("%d ",a[i]);
    }
}
