#include<stdio.h>

/*（本题不会的地方）
 *
 * 1.如果不高兴输出最不高兴的是周几
 * 2.如果两天或者两天以上不高兴的程度相当，则输出时间最靠前的一天
 *
*/



int main()
{
    int arr[7];//记录结果，判断是否会不高兴
    int a,b;
    for(int i=0;i<7;i++)
    {
        scanf("%d%d",&a,&b);
        arr[i]=a+b;
    }
    //这两步是精髓，给变量附上初值就可以实现如果大于8就改变，否则就是0
    int ans=0;
    int maxtime=8;
    for(int i=0;i<7;i++)
    {
        //输出最大的那一天，只要比当前的最大值大就更新
        if(arr[i]>maxtime)
        {
            maxtime=arr[i];
            ans=i+1;
        }
        //相同就输出时间靠前的那一天
        else if(arr[i]>8&&arr[i]==maxtime)
        {
            //                 核心语句
            // 如果在之前就有符合条件的日期，再次相同时就重新赋值
            // 如果之前有，那if条件为假，就不会重新赋值
            if(ans==0)
            {
                ans=i+1;
            }
        }
    }
    printf("%d",ans);
}