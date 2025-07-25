//    *
//   ***
//  *****
// *******
//*********
// *******
//  *****
//   ***
//    *

//思路：一个正立等腰三角形+倒立等腰三角形（下面的三角形行数比上面少一，同时是从正三角形的第二行空格的个数开始的）

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        for(int k=n-i;k>=1.;k--)
        {
            printf(" ");
        }
        for(int j=1;j<=2*i-1;j++)
        {
            printf("*");
        }
        printf("\n");
    }
    for(int i=1;i<=n-1;i++)
    {
        for(int k=1;k<=i;k++)//这里不再是i-1，因为第一行就有1个空格，特点就是正立三角行的第二行的空格数
        {
            printf(" ");
        }
        for(int j=2*(n-i+1-1)-1;j>=1;j--)
        {
            printf("*");
        }
        printf("\n");
    }
}