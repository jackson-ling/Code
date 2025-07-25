#include<stdio.h>
int main()
{
    int a1,a2,a3;
    int a[3];
    char arr[4];
    for(int i=0;i<3;i++)
    {
        scanf("%d",&a[i]);
    }
    scanf("%s",arr); //数组本身就是一个地址，可以不取地址;
    for(int i=0;i<2;i++)
    {
        for(int j=0;j<2-i;j++)
        {
            int temp;
            if(a[j]>a[j+1])
            {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }
    }
    a1=a[0];
    a2=a[1];
    a3=a[2];
    for(int i=0;i<3;i++)
    {
        if(arr[i]=='A')
        {
            printf("%d ",a1);
        }
        else if(arr[i]=='B')
        {
            printf("%d ",a2);
        }
        else if(arr[i]=='C')
        {
            printf("%d ",a3);
        }
    }
}