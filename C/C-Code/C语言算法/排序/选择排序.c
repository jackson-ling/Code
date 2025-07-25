#include <stdio.h>
/*

排序原理：遍历每一个元素，将当前遍历的元素和后面的所有元素比较，把更小的元素排在前面，二者交换位置

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

    // 选择排序
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++) // 和当前元素后面的所有元素进行比较，只有有更小的就交换位置，把小的排在前面
        {
            int temp;
            if (arr[i] >= arr[j])
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    // 打印输出
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}