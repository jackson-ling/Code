#include<stdio.h>
#include<math.h>
#define pai 3.141593
int main()
{
    int n;
    scanf("%d",&n);
    if(n==1)
    {
        printf("I love Luogu!");
    }
    else if(n==2)
    {
        printf("%d %d",6,4);
    }
    else if(n==3)
    {
        printf("%d\n%d\n%d",3,12,2);
    }
    else if(n==4)
    {
        printf("%.6g",500.0/3);//新知识：保留有效数字用—— ——“%g”
    }
    else if(n==5)
    {
        printf("%d",(260+220)/(12+20));
    }
    else if(n==6)
    {
        printf("%f",pow(117,0.5));
    }
    else if(n==7)
    {
        printf("%d\n%d\n%d\n",110,90,0);
    }
    else if(n==8)
    {
        float c,s,v;
        c=2*pai*5;
        s=pai*5*5;
        v=(pai*5*5*5*4)/3.0;
        printf("%f\n%f\n%f\n",c,s,v);
    }
    else if(n==9)
    {
        printf("%d",22);
    }
    else if(n==10)
    {
        printf("%d",9);
    }
    else if(n==11)
    {
        printf("%f",100./3);
    }
    else if(n==12)
    {
        char arr[27]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int i=0;i<26;i++)
        {
            if(arr[i]=='M')
            {
                printf("%d\n",i+1);
            }
        }
        printf("%c",arr[17]);

    }
    else if(n==13)
    {
        float v1=(pai*4*4*4*4)/3;
        float v2=(pai*10*10*10*4)/3;
        float v=v1+v2;
        printf("%d",(int)pow(v,1.0/3));//注意：这里的操作数类型，1/3不会输出小数结果，需要转换类型
    }
    else if(n==14)
    {
        printf("%d",50);
    }

}
