#include <stdio.h>
#include <string.h>
/*

逆序输出字符/数字

思路一：使用数组逆序打印结果

思路二：使用数字拆分法

思路三：根据输出特点可以发现是先进后出的特点，可以使用栈

*/
int main()
{
    // 使用数组逆序输出字符串（适用负数，小数，字符）
    char c[100];
    scanf("%s", c);
    for (int i = strlen(c) - 1; i >= 0; i--)
    {
        printf("%c", c[i]);
    }
    return 0;

    // 使用数组逆序输出数字

    // 对于正数，如果是  ““负数””  也要使用数组方法，可以参考上面的方法，转成字符窜处理
    int a[100];
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = n - 1; i >= 0; i--)
    {
        printf("%d ", a[i]);
    }

    // 使用数字拆分法逆序输出正数
    int x, sum = 0;
    scanf("%d", &x);
    while (x)
    {
        sum = sum * 10 + x % 10;
        x /= 10;
    }
    printf("%d", sum);

    // 使用数字拆分法逆序输出负数
    int x1, sum1 = 0, temp;
    scanf("%d", &x1);

    // 把负数转成正数

    // 处理方法1（推荐）
    temp = -x1;

    // 处理方法2
    // temp = x1 + 2 * (-x1);

    while (temp)
    {
        sum1 = sum1 * 10 + temp % 10;
        temp /= 10;
    }
    printf("-%d", sum1);
}