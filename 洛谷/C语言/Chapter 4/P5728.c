#include<stdio.h>
#include<math.h>
int main()
{
    int n,cnt=0;
    scanf("%d",&n);
    int a[n][3];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<3;j++)
        {
            scanf("%d",&a[i][j]);
        }
    }
    for(int i=0;i<n-1;i++)  //遍历第i行，防止越界，到n-1行结束
    {
        for(int j=i+1;j<n;j++)  //遍历第i+1行
        {
            int tot1=0;
            int tot2=0;
            tot1+=a[i][0]+a[i][1]+a[i][2];
            tot2+=a[j][0]+a[j][1]+a[j][2];
            if(abs(a[i][0]-a[j][0])<=5&&abs(a[i][1]-a[j][1])<=5&&abs(a[i][2]-a[j][2])<=5&&abs(tot1-tot2)<=10)
            {
                cnt+=1;
            }
        }
    }
    printf("%d",cnt);
}