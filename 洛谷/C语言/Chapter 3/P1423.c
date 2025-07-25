#include<stdio.h>
int main()
{
    float s,temp=0;
    int cnt=0;
    scanf("%f",&s);
    while(temp<s)
    {
        temp=2+0.98*temp;
        cnt+=1;
    }
    printf("%d",cnt);

}