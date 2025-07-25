#include<stdio.h>
#include<stdbool.h>
#include<math.h>

//判断是否是回文数
int isprime_palindromes (int n)
{
    int back_up=n;
    int sum=0;
    while(n)
    {
        //重点的两个式子，好好理解这个过程
        sum=sum*10+n%10;
        n/=10;
    }
    if(back_up==sum)
    {
        return true;
    }
    else
    {
        return false;
    }
}

//判断是否是质数(这里采用一种更简单的方法)
int isprime(int n)
{
    if(n<2)
    {
        return false;
    }
    for(int i=2;i<=sqrt(n);i++)
    {
        if(n%i==0)  //如果能找到其他因数整除，说明不是素数
        {
            return false;
        }
        //如果return true  放在循环内，只要有符合的直接结束，就会遗漏一些数字没有被检查
    }
    return true;  //易错：注意这个语句的位置，逻辑：检查完循环种所有的数字，如果都没有可以整除的，就说明是素数

}


//  第一种方法超时了，遍历每一个数，如果不是质数就花费了不必要的时间，可以先判断是否是质数

//int main()
//{
//    int a,b;
//    scanf("%d%d",&a,&b);
//    for(int i=a;i<=b;i++)
//    {
//        for(int j=2;j<i;j++)
//        {
//            if(i==j)
//            {
//                if(isprime_palindromes(i))
//                {
//                    printf("%d\n",i);
//                }
//            }
//            if(i%j==0)
//            {
//                break;
//            }
//        }
//    }
//}


int main()
{
    int a,b;
    scanf("%d%d",&a,&b);
    for(int i=a;i<=b;i++)
    {
        //及时通过优化还是会出现连个测试点TLE，这里需要用更高效的算法才可以了---------埃氏筛法
        if(isprime(i)&&isprime_palindromes(i))
        {
            printf("%d\n",i);
        }
    }
}

