#include <stdio.h>

// 非递归算法
int binarysearch(int arr[], int left, int right, int target)
{
    while (left <= right)
    {
        int mid = (left + right) / 2; // 区间边界很大的时候可能会发生溢出
        // 防止溢出的写法
        // int mid = left + (right - left) / 2;
        if (arr[mid] == target)
        {
            return mid;
        }
        else if (target < arr[mid])
        {
            right = mid - 1; // 使用加一是为了防止中间值再次被查找一次（在之前的查找中本来就是不符合条件的）
        }
        else
        {
            left = mid + 1;
        }
    }
    return -1; // 没有找到
}

// 递归写法
int binarysearch_recursion(int arr[], int left, int right, int target)
{
    // 递归出口
    if (left > right)
    {
        return -1;
    }

    int mid = (left + right) / 2; // 区间边界很大的时候可能会发生溢出
    // 防止溢出的写法
    // int mid = left + (right - left) / 2;
    if (arr[mid] == target)
    {
        return mid;
    }
    else if (target < arr[mid])
    {
        return binarysearch_recursion(arr, left, mid - 1, target);
    }
    else
    {
        return binarysearch_recursion(arr, mid + 1, right, target);
    }
}