#include<stdio.h>
int main()
{
    int n;
    scanf("%d",&n);
    int arr[n];

    //方法一：逐个搜索，不断更新最大最小值
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    int max=0,min=1000; //注意最大值最小值的初始化技巧
    for(int i=0;i<n;i++)
    {
        if(arr[i]>=max)
        {
            max=arr[i];
        }
    }
    for(int i=0;i<n;i++)
    {
        if(arr[i]<=min)
        {
            min=arr[i];
        }
    }
    printf("%d",max-min);

    //方法二：给所有数字排序，最大减最小即是答案

             //冒泡排序
//    for(int i=0;i<n-1;i++)
//    {
//        for(int j=0;j<n-i-1;j++)
//        {
//            int temp;
//            if(arr[j]>arr[j+1])
//            {
//                temp=arr[j];
//                arr[j]=arr[j+1];
//                arr[j+1]=temp;
//            }
//        }
//    }

//选择排序
//    for(int i=0;i<n-1;i++)
//    {
//        for(int j=i+1;j<n;j++)
//        {
//            int temp;
//            if(arr[i]>arr[j])
//            {
//                temp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
//            }
//        }
//    }
    printf("%d",arr[n-1]-arr[0]);
}
