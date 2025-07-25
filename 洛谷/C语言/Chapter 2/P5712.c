#include<stdio.h>
int main()
{
    int a;
    scanf("%d",&a);
    if(a==1)
    {
        printf("Today, I ate %d apple.",a);
    }
    else if(a==0)
    {
        printf("Today, I ate 0 apple.");
    }
    else
    {
        printf("Today, I ate %d apples.",a);
    }
}