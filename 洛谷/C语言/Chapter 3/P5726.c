#include<stdio.h>

int main()
{
    int n,cnt=0,sum=0;
    scanf("%d",&n);
    int a[n];
    for(int i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    for(int i=0;i<n-1;i++)
    {
        for(int j=0;j<n-1-i;j++)
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
    for(int i=1;i<=n-1-1;i++)
    {
        sum+=a[i];
        cnt+=1;
    }
    printf("%.2f",(float)sum/(float)cnt);
}