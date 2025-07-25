#include<stdio.h>
#include<math.h>
int main()
{
    int m,t,s,temp,ans;
    scanf("%d%d%d",&m,&t,&s);
    if(t==0)
    {
        printf("%d",0);
    }
    else
    {
        temp=(int)ceil((float)s/t);//如果吃的苹果数量出现小数，向上取整
        ans=m-temp;
        if(s<t)//遗漏点：没有考虑到现有的时间不足以吃完一个苹果
        {
            printf("%d",m-1);
        }
        else if(ans<=0)//遗漏点：没有考虑到其实已经吃完了但是时间还多了（也反映了他一点也不利索）
        {
            printf("%d",0);
        }
        else//说明吃苹果很利索，一点时间也不浪费
        {
            printf("%d",ans);
        }
    }
}
