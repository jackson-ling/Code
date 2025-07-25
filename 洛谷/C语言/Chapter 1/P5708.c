#include<stdio.h>
#include<math.h>
int main()
{
    float a,b,c,p,s;
    scanf("%f%f%f",&a,&b,&c);
    p=(a+b+c)/2;
    s=p*(p-a)*(p-b)*(p-c);
    printf("%.1f",pow(s,0.5));
}