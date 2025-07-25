#include<stdio.h>
int main()
{
    int arr[10];
    int max_height;
    int cnt;
    for(int i=0;i<10;i++)
    {
        scanf("%d",&arr[i]);
    }
    scanf("%d",&max_height);
    for(int i=0;i<10;i++)
    {
        int ans=30+max_height;
        if(ans>=arr[i])
        {
            cnt+=1;
        }
    }
    printf("%d",cnt);
}
