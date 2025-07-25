#include<stdio.h>
int main()
{
    int n,min;
    scanf("%d",&n);
    int a[n];
    for(int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    min=a[0]; //注意初始化位置，如果放在循环里面，那每一轮循环min的值被重新赋值，相当于值没变，一直都是a[0]
    for(int i=0;i<n;i++)
    {

        if(a[i]<min)
        {
            min=a[i];
        }
    }
    printf("%d",min);
}
