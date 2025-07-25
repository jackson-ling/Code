#include<stdio.h>
#include<math.h>
int main()
{
    int n;
    //易错：应使用double类型，提高精度，使用float的话精度不够，就无法全部AC
    double fn,a,b,a1,b1,c=sqrt(5);
    scanf("%d",&n);
    a=(1+c)/2;
    a1=pow(a,n);
    b=(1-c)/2;
    b1=pow(b,n);
    fn=(a1-b1)/c;
    printf("%.2f",fn);
}