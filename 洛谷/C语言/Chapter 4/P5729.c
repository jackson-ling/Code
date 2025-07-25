#include<stdio.h>

// 不会的点：如何计算切割的点的总个数？

// 思路：运用三维数组，还是打标记思想，一个个点循环遍历模拟，最后计算出切割的点

int main()
{
    int a[25][25][25]={0};  //初始化数组全为0，值为1表示被切割了
    int q,tot=0;
    int x,y,z;
    int x1,y1,z1;
    int x2,y2,z2;
    scanf("%d%d%d",&x,&y,&z);
    scanf("%d",&q);


    //切割 q 次，每一次切割都去模拟，运用循环来打标记被切割的点
    for(int n=1;n<=q;n++)
    {
        scanf("%d%d%d%d%d%d",&x1,&y1,&z1,&x2,&y2,&z2);
        for(int i=x1;i<=x2;i++)
        {
            for(int j=y1;j<=y2;j++)
            {
                for(int k=z1;k<=z2;k++)
                {
                    a[i][j][k]=1;
                }
            }
        }
    }
    for(int i=1;i<=x;i++)
    {
        for(int j=1;j<=y;j++)
        {
            for(int k=1;k<=z;k++)
            {
                if(a[i][j][k]==0)
                {
                    tot+=1;
                }
            }
        }
    }
    printf("%d",tot);
}
