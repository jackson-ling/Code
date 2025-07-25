#include <stdio.h>
int main()
{
    int n, temp = 0;
    scanf("%d", &n);
    int back_up = n; // 注意逻辑，先输入了n才有值，之后才可以赋值给back_up
    while (n)
    {
        // 最核心的两句
        temp = temp * 10 + n % 10;
        n /= 10;
    }
    if (back_up == temp) // 注意：应该是和temp比较
    {
        printf("n:%d\n", temp);
        printf("back_up:%d\n", back_up);
        printf("n is a palindrome number\n");
    }
    else
    {
        printf("n:%d\n", temp);
        printf("back_up:%d\n", back_up);
        printf("n isn't a palindrome number\n");
    }
}