#include<stdio.h>
int main()
{
    int n,tot=0;
    scanf("%d",&n);
    int a[n];
    for(int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(a[j]<a[i])
            {
                tot+=1;
            }
        }
        printf("%d ",tot); //注意输出位置，递增完之后输出结果

        //每一次循环结束之后要重置，因为对于每一只小鱼前面比自己不可爱的小鱼数是不一样的
        // 同时不可以再之前的基础上继续累加
        tot=0;
    }
}