#include<stdio.h>
#include<stdlib.h>
//#define maxsize 20000
// 这里的数不能太大，否则内存溢出会自动结束进程然后报错,可以考虑动态分配内存
typedef struct
{
    int *data;
    int length;
}sqlist;

int main()
{
    sqlist l;
    int n,m;
    scanf("%d%d",&n,&m);
    l.data=(int *)malloc(sizeof(int)*n);
    l.length=n;
    for(int i=0;i<n;i++)
    {
        scanf("%d",&l.data[i]);
    }
    for (int i=0;i<m;i++)
    {
        int a;
        scanf("%d",&a);//对使用循环实现多次录入数据的理解还不够

        //补充：如果每次只允许录入一个数据，拿循环多次就实现了这个功能

        if (a>=1&&a<=n)//注意初始条件，题目说的是取值编号是从1开始的，取值的范围要合理
        {
            printf("%d\n", l.data[a-1]); //易错：物理位置和数组下标相差1
        }
    }
    free(l.data);
}

