#include<stdio.h>

//崛起分段计算的数学思想，运用循环依次遍历打标记是核心

int main()
{
    int l,m,u,v,tot=0;
    int a[10005];  // 标记所有数，如果为1表示有树，如果为0表示没有树
    //易错：区别于0的初始化，这里需要使用循环初始化每一个数，而0是默认全部初始化
    for(int i=0;i<10005;i++)
    {
        a[i]=1;
    }
    scanf("%d%d",&l,&m);
    for(int i=0;i<m;i++)
    {
            scanf("%d%d",&u,&v);
            for(int k=u;k<=v;k++)
            {
                a[k]=0;
            }
    }
    for(int i=0;i<=l;i++) // 断点值的树也要计算，遍历到 l 的位置
    {
        if(a[i]==1)
        {
            tot+=1;
        }
    }
    printf("%d",tot);
}
