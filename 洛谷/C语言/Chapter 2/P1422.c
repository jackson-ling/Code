#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    float ans,ans1,ans2;
    if(n<=150)
    {
        ans=n*0.4463;
        printf("%.1f",ans);
    }
    else if(n>=151&&n<=400)
    {
        ans1=(n-150)*0.4663+150*0.4463;
        printf("%.1f",ans1);
    }
    else if(n>=401)
    {
        ans2=150*0.4463+250*0.4663+(n-400)*0.5663;
        printf("%.1f",ans2);
    }

}