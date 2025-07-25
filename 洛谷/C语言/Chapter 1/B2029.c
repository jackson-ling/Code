//没掌握的点：对数值类型的计算和操作结果的理解

#define pai 3.14
#include<stdio.h>
#include<math.h>
int main()
{
    int r,h;
    scanf("%d%d",&h,&r);
    //首先v的结果是小数类型的，但是计算过程中有小数3.14，和整数的计算结果仍然是小数类型的
    float v=3.14*r*r*h;
    //首先ans的结果是小数类型的，但是计算过程中有浮点数v，操作的结果是小数类型的
    float ans=20000/v;
    printf("%d",(int)(ceil(ans)));
    return 0;
}
