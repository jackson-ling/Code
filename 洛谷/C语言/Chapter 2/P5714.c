#include<stdio.h>
int main()
{
    float m,h,BMI;
    scanf("%f%f",&m,&h);
    BMI=m/(h*h);
    if(BMI<18.5)
    {
        printf("Underweight");
    }
    else if(BMI>=18.5&&BMI<24)
    {
        printf("Normal");
    }
    else if(BMI>=24)
    {
        printf("%.6g\n",BMI);
        printf("Overweight");
    }
}

