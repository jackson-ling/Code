````c
//*
//**
//***
//****
#include<stdio.h>
int main()
{
    int i,j,n;
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=i;j++)
        {
            printf("*");
        }
        printf("\n");
    }

}


//    *
//   **
//  ***
// ****
//*****
#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        for(int k=n-i;k>=1;k--)
        {
            printf(" ");
        }
        for(int j=1;j<=i;j++)
        {
            printf("*");
        }
        printf("\n");
    }
}


//*****
// ****
//  ***
//   **
//    *

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        for(int k=1;k<=i-1;k++)
        {
            printf(" ");
        }
        for(int j=1;j<=n-i+1;j++)
        {
            printf("*");
        }
        printf("\n");
    }
}



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


//    *
//   ***
//  *****
// *******
//*********

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
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



//本质就是直角三角形的打印，只需要控制每一行的个数都相同就行
//这里以右下直角三角形的朝向举例子，其余朝向大同小异

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);//控制平行四边形的行数
    for(int i=1;i<=n;i++)
    {
        for(int k=n-i;k>=1;k--)
        {
            printf(" ");
        }
        for(int j=1;j<=3;j++)//控制平行四边形的边长
        {
            printf("*");
        }
        printf("\n");
    }
}



//     *****
//    *****
//   *****
//  *****
// *****

//本质就是直角三角形的打印，只需要控制每一行的个数都相同就行
//这里以右下直角三角形的朝向举例子，其余朝向大同小异

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);//控制平行四边形的行数
    for(int i=1;i<=n;i++)
    {
        for(int k=n-i;k>=1;k--)
        {
            printf(" ");
        }
        for(int j=1;j<=3;j++)//控制平行四边形的边长
        {
            printf("*");
        }
        printf("\n");
    }
}



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

```c
//*
//**
//***
//****
#include<stdio.h>
int main()
{
    int i,j,n;
    scanf("%d",&n);
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=i;j++)
        {
            printf("*");
        }
        printf("\n");
    }

}


//    *
//   **
//  ***
// ****
//*****
#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        for(int k=n-i;k>=1;k--)
        {
            printf(" ");
        }
        for(int j=1;j<=i;j++)
        {
            printf("*");
        }
        printf("\n");
    }
}


//*****
// ****
//  ***
//   **
//    *

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
    {
        for(int k=1;k<=i-1;k++)
        {
            printf(" ");
        }
        for(int j=1;j<=n-i+1;j++)
        {
            printf("*");
        }
        printf("\n");
    }
}



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


//    *
//   ***
//  *****
// *******
//*********

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
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



//本质就是直角三角形的打印，只需要控制每一行的个数都相同就行
//这里以右下直角三角形的朝向举例子，其余朝向大同小异

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);//控制平行四边形的行数
    for(int i=1;i<=n;i++)
    {
        for(int k=n-i;k>=1;k--)
        {
            printf(" ");
        }
        for(int j=1;j<=3;j++)//控制平行四边形的边长
        {
            printf("*");
        }
        printf("\n");
    }
}



//     *****
//    *****
//   *****
//  *****
// *****

//本质就是直角三角形的打印，只需要控制每一行的个数都相同就行
//这里以右下直角三角形的朝向举例子，其余朝向大同小异

#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);//控制平行四边形的行数
    for(int i=1;i<=n;i++)
    {
        for(int k=n-i;k>=1;k--)
        {
            printf(" ");
        }
        for(int j=1;j<=3;j++)//控制平行四边形的边长
        {
            printf("*");
        }
        printf("\n");
    }
}



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

````

---

## 总结

## 对于\*的个数

## 1.正立：行数=个数

## 2.倒立：n-i+1

---

## 对于空格的个数

## 1.正立：n-i，空格数递减

## 2.倒立：i-1，空格数递增

---

## 等腰三角形的个数（本质是由行数和个数的关系变成奇数的表示）

## 正立：2\*i-1

## 倒立：2\*（n-i+1）-1

## 本质：2\*（）-1，括号的内容就是正立和倒立的时候行数和个数的关系
