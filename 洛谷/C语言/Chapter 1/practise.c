#include <stdio.h>
#include <math.h>

int main()
{
    float a,b,c,p;
    scanf("%f%f%f",&a,&b,&c);
    p = 0.5 * (a + b + c);
    printf("%.1lf", sqrt(p * (p - a) * (p - b) * (p - c)));
    return 0;
}
