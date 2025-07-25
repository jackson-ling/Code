#include<stdio.h>
int main()
{
    int a[100]={0};
    int count=0;
    for(int i=0;i<99;i++)
    {
        int n;
        scanf("%d",&n);
        if(n!=0)
        {
            a[i]=n;
            count+=1; //count计算的是数据的个数，实际上第一个数据的数组下标是0
        }
        else
        {
            break;
        }
    }
    for(int i=count-1;i>=0;i--)
    {
        printf("%d ",a[i]);
    }
}
