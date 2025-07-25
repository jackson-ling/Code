#include<stdio.h>
//本题的核心：只要关注非工作日天数来计算游泳的天数
int main()
{
    int x,n,temp,ans=0;
    scanf("%d%d",&x,&n);
    //先计算第一周的
    if(x<=5)
    {
        for(int i=x;i<=5;i++)
        {
            ans+=250;
        }
    }
    //计算剩余天数中游泳的天数(用（7-x+1）的天数补齐为第一周，剩余的就可以视为整周数来做判断)
    temp=n-(7-x+1);
    //需要考虑temp小于0的情况
    if(temp>0)
    {
        int zhengzhoushu=temp/7;
        int shengyutianshu=temp%7;
        //先处理整周数
        ans+=zhengzhoushu*5*250;
        //处理剩余天数（理解：不用写判断，如果没有剩余，就不会被执行）

        //判断剩余天数是否为周六日
        if(shengyutianshu==6||shengyutianshu==7)
        {
            ans+=5*250;//如果剩余天数是周六日，实际游泳天数只有五天
        }
        else
        {
            ans+=shengyutianshu*250;
        }
    }

    printf("%d",ans);
}

//标准题解（已经知道了起始是周几，那就遍历加上的每一天，再结合一周一轮循环）
/*
     for(int i=1;i<=n;i++)
    {
        //已经知道了起始是周几，遍历每一天，每一次循环x就自增一天
        if(x!=6&&x!=7)
        {
            ans+=250;
        }
        if(x==7)
        {
            x=1;  //如果这一天是周日，就重置是周几，一周7天为一轮
        }
        else
        {
            x++;
        }
    }
    printf("%d",ans);
*/

