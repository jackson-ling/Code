/*
 * 本题目要求输出整数，使用浮点数的两个注意点
 * 1.“%.0f”会自动四舍五入出现误差
 * 2.可以使用floor（）函数向下取整
 * 3.输出结果使用强制类型转换
*/


#include<stdio.h>
#include<math.h>
int main()
{
    int a,b;
    scanf("%d%d",&a,&b);
    float c,d,ans;
    c=a+0.1*b;
    d=1.9;
    ans=c/d;
    printf("%d",(int)floor(ans));

}
