#include<stdio.h>
int main()
{
    int x;
    scanf("%d",&x);
    //小A
    if(x%2==0&&(x>4&&x<=12))
    {
        printf("%d ",1);
    }
    else
    {
        printf("%d ",0);
    }
    //uim
    if(x%2==0||x>4&&x<=12||x%2==0&&(x>4&&x<=12))
    {
        printf("%d ",1);
    }
    else
    {
        printf("%d ",0);
    }
    //小B
    if(x%2==0&&!(x>4&&x<=12)||x%2!=0&&(x>4&&x<=12))
    {
        printf("%d ",1);
    }
    else
    {
        printf("%d ",0);
    }
    //正妹
    if(!(x%2==0&&(x>4&&x<=12)))
    {
        printf("%d ",1);
    }
    else
    {
        printf("%d ",0);
    }