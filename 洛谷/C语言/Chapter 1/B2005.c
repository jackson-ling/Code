#include<stido.h>
int main()
{
    char c;
    scanf("%d",&c);
    for(int i=1;i<=3;i++)
    {
        for(int k=3-i;k>=1;k--)
        {
            printf(" ");
        }
        for(int j=1;j<=2*1-1;j++)
        {
            printf("%c",c);
        }
    }

}