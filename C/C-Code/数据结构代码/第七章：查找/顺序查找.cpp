#include <stdio.h>
#include <stdlib.h>
/*

顺序查找
1.适用范围：顺序结构（顺序表和链表）
2.思想：逐个遍历，逐个匹配
3.时间效率低

注意点
1. 第一个位置不用，从数组下标为一的位置开始存储，返回查找元素的数组下标
2. 从最后一个元素开始查找

*/

typedef int elemtype;
typedef int status;

// 方法一：逐个遍历
status ssearch1(int arr[], int target, int len)
{
    for (int i = len; i >= 1; i--)
    {
        if (arr[i] == target)
        {
            return i;
        }
    }
    return -1; // 没有找到
}

// 方法二：改进版本（防止越界）
status ssearch2(int arr[], int target, int len)
{
    int i;
    // 把数组的第0号位置设置为target值
    arr[0] = target; // 如果找到了就返回数组下标，如果返回0就代表找不到
    for (i = len; arr[i] != target; i--)
    {
        ;
    }
    return i;
}
