#include <stdio.h>
/*

排序原理：每两个元素之间比较，小的就放在前面，交换位置，之后继续遍历直到把最小的放到最前面，全部数字排完

*/
int main()
{
    int n;
    scanf("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    // 冒泡排序
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            int temp;
            if (arr[j] >= arr[j + 1])
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    // 打印输出
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}