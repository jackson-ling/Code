#include <stdio.h>
#include <string.h>

#define ok 1
#define error 0

typedef struct
{
    char arr[101];
    int length;
} string;

// 写一个初始化字符窜的函数
int stringinit(string &s)
{
    printf("please input the string:");
    // 易错：由于是从下标为一的位置开始存储，所以这里录入的时候也应该从下标为一的位置开始录入
    scanf("%s", s.arr + 1);
    // 易错：同理是一样的问题，从下标为1的位置开始往后统计字符
    s.length = strlen(s.arr + 1);
    printf("the string's length which you have input is : %d\n", s.length);
    printf("\n");
    printf("input success\n");
    printf("\n");
    return ok;
}

void getnextval(string b, int nextval[])
{
    // 这里的 i（后缀指针） j（前缀指针） 都是针对模式串，i可以理解是移动的指针，书上的是从1开始计数
    int i = 1;
    nextval[1] = 0;
    int j = 0;
    while (i < b.length) // 易错：这里不取等，确保 i++ 之后 i<b.length
    {
        if (j == 0 || b.arr[i] == b.arr[j])
        {
            i++;
            j++;
            if (b.arr[i] != b.arr[j])
            {
                nextval[i] = j;
            }
            else
            {
                nextval[i] = nextval[j];
            }
        }
        else
        {
            j = nextval[j];
        }
    }
}

int KMP(string a, string b, int position)
{
    int i = position;
    int j = 1;
    // 易错：这里需要初始化nextval数组,计算nextval数组的值
    int nextval[101];
    getnextval(b, nextval);
    while (i <= a.length && j <= b.length)
    {
        if (j == 0 || a.arr[i] == b.arr[j])
        {
            i++;
            j++;
        }
        else
        {
            j = nextval[j];
        }
    }
    if (j > b.length)
    {
        printf("match successful\n");
        printf("The starting position of the match is :%d\n", i - b.length);
        return ok;
    }
    else
    {
        printf("fail to match\n");
        return error;
    }
}

int main()
{
    int position = 1;
    string a;
    string b;
    stringinit(a);
    stringinit(b);
    KMP(a, b, position);
}