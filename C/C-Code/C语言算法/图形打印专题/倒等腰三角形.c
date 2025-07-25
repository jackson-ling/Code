//*********
// *******
//  *****
//   ***
//    *

//巧妙的思路：有了正等腰三角形的基础，只需要控制行的变化就可以实现，优先控制最后一行就可以实现
//常规思路：已经知道倒立的直角三角形的行规律是（n-i+1），只需要变成奇数就行，即2*（n-i+1）-1


//常规思路
// #include<stdio.h>
// int main()
// {
//     int n;
//     scanf("%d",&n);
//     for(int i=1;i<=n;i++)
//     {
//         for(int k=1;k<=i-1;k++)
//         {
//             printf(" ");
//         }
//         for(int j=2*(n-i+1)-1;j>=1;j--)
//         {
//             printf("*");
//         }
//         printf("\n");
//     }
// }



//巧妙思路：利用正立的等腰三角形作为基础，控制行数就可以是实现
#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for (int i=n;i>=1;i--)
    {
        for(int k=n-i;k>=1;k--)
        {

            printf(" ");
        }
        for(int j=1;j<=2*i-1;j++)
        {
            printf("*");
        }
        printf("\n");
    }
}