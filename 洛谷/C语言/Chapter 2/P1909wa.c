#include<stdio.h>

//在说明/提示中，本题只考虑购买一种包装来满足需求，这是没注意的点

int main()
{
    int n,a,b,c,p1,p2,p3,ans,min;//记录最小花费，如果有更便宜的就更新
    scanf("%d",&n);
    scanf("%d%d",&a,&p1);
    scanf("%d%d",&b,&p2);
    scanf("%d%d",&c,&p3);

    int tot1,tot2,tot3;//记录每种包装需要的数量

    //计算第一种包装
    if(n%a==0)
    {
        tot1=n/a;
        ans=tot1*p1;
    }
    else
    {
        tot1=(n/a)+1;
        ans=tot1*p1;
    }
    min=ans;  //记录下当前需要花费的数额

    //计算第二种包装
    if(n%b==0)
    {
        tot2=n/b;
        ans=tot2*p2;
    }
    else
    {
        tot2=(n/b)+1;
        ans=tot2*p2;
    }
    //如果当前的数额比之前的还小，说明当前的更便宜，更新最小花费
    if(min>ans)
    {
        min=ans;
    }

    //计算第三种包装
    if(n%c==0)
    {
        tot3=n/c;
        ans=tot3*p3;
    }
    else
    {
        tot3=(n/c)+1;
        ans=tot3*p3;
    }
    if(min>ans)
    {
        min=ans;
    }
    printf("%d",min);
}