#include<stdio.h>

int main() {
    int a[3];
    int n = 3;
    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }


//    //冒泡排序
    for(int i=0;i<n-1;i++)
    {
        for(int j=0;j<n-1-i;j++)
        {
            if(a[j]>a[j+1])
            {
                int temp;
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }

    }
    for(int i=0;i<n;i++)
    {
        printf("%d ",a[i]);
    }

    //选择排序
//    for (int i = 0; i < n - 1; i++)
//    {
//        for (int j = 1; j < n; j++)
//        {
//            if (a[i] > a[j])
//            {
//                int temp;
//                temp = a[i];
//                a[i] = a[j];
//                a[j] = temp;
//            }
//        }
//    }
//    for (int i = 0; i < n; i++)
//    {
//        printf("%d ", a[i]);
//    }
}

