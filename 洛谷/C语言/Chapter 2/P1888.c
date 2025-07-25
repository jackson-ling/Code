#include<stdio.h>
//#include<math.h>   //C语言没有gcd这个内置函数

//欧几里得算法（辗转相除法）  求a和b的最大公约数转为求b和a%b的最大公约数
//这里直接记住，会用就行，后面再慢慢理解原理
int gcd(int a,int b)
{
    if(b==0)
    {
        return a;
    }
    return gcd(b,a%b);
}
//一直递归这个过程，直到b=0，此时a就是二者的最大公约数

int main()
{
    int a,b,c,ans;
    int arr[3];
    for(int i=0;i<3;i++)
    {
        scanf("%d",&arr[i]);
    }
    //选择排序
    for(int i=0;i<2;i++)
    {
        for(int j=i+1;j<3;j++)
        {
            int temp;
            if(arr[i]>arr[j])
            {
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    a=arr[0];
    b=arr[1];
    c=arr[2];
    ans=gcd(a,b);
    printf("%d/%d",a/ans,c/ans);
}
