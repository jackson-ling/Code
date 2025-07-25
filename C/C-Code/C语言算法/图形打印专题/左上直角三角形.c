//*****
//****
//***
//**
//*

#include<stdio.h>
int main()
{
    int n;//定义行数
    scanf("%d",&n);
    for(int i=1;i<=n;i++)//控制行数
    {
        for(int j=n-i+1;j>=1;j--)
        {
            printf("*");
        }
        printf("\n");//打印完*之后换行
    }
}