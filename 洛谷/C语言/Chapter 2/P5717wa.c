#include <stdio.h>

//本题目卡住的点：1.逻辑问题  2.对if-else if-else结构的运行理解，导致了逻辑混乱

//注意：程序会组个判断，只要写出每一个情况，只要符合了就会执行，同时注意换行输出

int main()
{
    int arr[3];
    int temp;
    for (int i = 0; i < 3; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 2 - i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    int a, b, c;
    a = arr[0];
    b = arr[1];
    c = arr[2];
    if (a + b <= c)
    {
        printf("Not triangle\n");
    }
    else
    {
        if (a * a + b * b == c * c)
        {
            printf("Right triangle\n");
        }
        else if (a * a + b * b > c * c)
        {
            printf("Acute triangle\n");
        }
        else if (a * a + b * b < c * c)
        {
            printf("Obtuse triangle\n");
        }

        //理解这里单独使用if的原因：在else if中如果有条件符合了就不会继续往下执行

        if (a == b || b == c || a == c)  //排序了,a==c可以不用写，但是等边也是特殊的等腰三角形，符合情况
        {
            printf("Isosceles triangle\n");
        }
        if (a == b && b == c)
        {
            printf("Equilateral triangle\n");
        }
    }
    return 0;
}