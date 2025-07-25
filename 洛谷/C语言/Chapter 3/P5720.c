#include<stdio.h>
int main()
{
    int a,cnt=0;
    scanf("%d",&a);
    while(a!=1)
    {
        a/=2;
        cnt+=1;
    }
    //易错：注意审题，题目问的是第几天木棍长度会变成1，从第二天开始锯，最后长度变成1还需要加上第一天（没有锯）
    //     表示第几天木头的长度变成1
    printf("%d",cnt+1);
}