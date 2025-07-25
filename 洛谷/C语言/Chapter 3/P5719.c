#include<stdio.h>
int main()
{
    int n,k,cnt1=0,cnt2=0,tot1=0,tot2=0;//易错：没有初始化数据就会出现问题
    scanf("%d%d",&n,&k);
    for(int i=1;i<=n;i++)
    {
        if(i%k==0)
        {
            tot1+=i;
            cnt1+=1;
        }
        if(i%k!=0)
        {
            tot2+=i;
            cnt2+=1;
        }
    }
    printf("%.1f %.1f",(float)tot1/(float)cnt1,(float)tot2/(float)cnt2);

}
