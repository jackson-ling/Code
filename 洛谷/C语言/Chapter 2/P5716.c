#include<stdio.h>

int runnian(int a)
{
    int ans;
    if(a%4==0&&a%100!=0)
    {
        ans=1;
    }
    else if(a%400==0)
    {
        ans=1;
    }
    else
    {
        ans=0;
    }
    return ans;
}

int main()
{
    int year,month,temp,ans;
    scanf("%d%d",&year,&month);
    int arr[13]={29,31,28,31,30,31,30,31,31,30,31,30,31};
    temp= runnian(year);
    if(temp)
    {
        for(int i=0;i<=12;i++)
        {
            if(temp&&month==2)
            {
                 ans=arr[0];
            }
            else
            {
                ans=arr[month];
            }
        }
    }
    else
    {
        for(int i=0;i<=12;i++)
        {
            if(temp&&month==2)
            {
                ans=arr[2];
            }
            else
            {
                ans=arr[month];
            }
        }
    }
    printf("%d",ans);
}