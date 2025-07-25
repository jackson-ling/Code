#include<stdio.h>
int main()
{
    int k,i=1,n=0;
    float sn=0;
    scanf("%d",&k);
    //对于未知条件的用while循环可以有效计算循环次数，并避免过多不必要的循环占用内存
    while(sn<(float)k)
    {
        sn+=1.0/(float)i; //易错：整数的除法结果还是整数，这里需要强转类型
        i++;
        n++;
        if(sn>=(float)k)
        {
            break;
        }
    }
    printf("%d",n);
}