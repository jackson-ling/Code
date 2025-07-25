#include<stdio.h>
int main()
{
    int a,b,c,d,e,f,time,time1,time2;
    scanf("%d%d%d%d",&a,&b,&c,&d);
    time1=a*60+b;
    time2=c*60+d;
    time=time2-time1;
    printf("%d %d",time/60,time%60);
}
