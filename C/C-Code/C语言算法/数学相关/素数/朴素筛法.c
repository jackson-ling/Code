#include <stdio.h>
int main()
{
    int n, tot = 0;
    scanf("%d", &n);
    printf("\n");
    for (int i = 2; i <= n; i++)
    {
        for (int j = 2; j <= i; j++)
        {
            // 理解：为什么是i=j，如果没有因数可以被整除，当遍历到当前数的时候说明这个数就是因数
            if (i == j)
            {
                printf("%-8d\t", i);
                tot++;
            }
            // 如果再（2，i）这个范围找到了因数可以整除就说明不是素数，后面呢也没必要再继续比较了，直接跳出循环
            if (i % j == 0)
            {
                break;
            }
        }
    }
    printf("\n");
    printf("total number: %d\n", tot);
}