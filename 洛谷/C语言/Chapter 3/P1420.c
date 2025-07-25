#include<stdio.h>
int main()
{
    int n,cnt=0,ans=0;
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    for(int i=0;i<n;i++)
    {
        if(arr[i+1]-arr[i]==1)
        {
            cnt+=1;
            //由于是求最长，用一个值去比较，如果更大就更新值（常用思想）
            if(cnt>ans)
            {
                ans=cnt;
            }
        }
        else
        {
            cnt=0;
        }
    }
    //假设最长连号有五个数，但是计算的是差值（也就是计算有多少个间隔），最后值加一才是最长连号的总数字数
    printf("%d",ans+1);
}