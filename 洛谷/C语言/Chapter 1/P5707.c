//#include<stdio.h>
//int main()
//{
//    int s,v,t;
//    scanf("%d%d",&s,&v);//不要溜掉取地址符----“&”
//    //优先计算需要的时间
//
//    //易错：取余只能用于整型变量,但是除法要产生小数要强转类型，这里做一个处理，难点！！！
//    float tempt = (float)s / v;
//    if (tempt - (int)tempt != 0)  // 判断是否存在小数部分
//    {
//        t = (int)tempt + 1;  // 向上取整
//    }
//    else
//    {
//        t = (int)tempt;  // 没有小数部分直接取整
//    }
//
//    //起始时间9：50，最后结果加上10分钟,接着分类
//
//    //1.先算一个小时之内的
//    if(t<50)
//    {
//        printf("07:%02d",50-t);
//    }
//    else if(t==50)
//    {
//        printf("07:00");
//    }
//    else
//    {
//        int tempt,hour,minute;
//        tempt=t-50;//起始时间是7：00
//        hour=tempt/60;
//        minute=tempt%60;
//
//        //易错：小时，分钟的结果可能是个位数，输出格式需要控制---“%02d”---不足两位数再前面补0
//
//        if(hour<7&&minute>0)
//        {
//            printf("%02d:%02d",7-hour-1,60-minute);
//        }
//        else if(hour<7&&minute==0)
//        {
//            printf("%02d:%02d",7-hour-1,minute);
//        }
//
//
//        else if(hour==7&&minute==0)
//        {
//            printf("00:00");
//        }
//        else if(hour==7&&minute>0)
//        {
//            printf("23:%02d",60-minute);
//        }
//        else if(hour>7&&minute==0)
//        {
//            printf("%02d:%02d",24-(hour-7),minute);
//        }
//        else if(hour>7&&minute>0)
//        {
//            printf("%02d:%02d",24-(hour-7)-1,60-minute);
//        }
//    }
//}


#include<stdio.h>
#include<math.h>
int main()
{
    int s,v,time,ans;
    scanf("%d%d",&s,&v);
    time=(int)ceil((float)s/v)+10;
    ans=8*60-time;
    if(ans>=0)
    {
        printf("%02d:%02d",ans/60,ans%60);
    }
    else
    {
        ans+=24*60;
        printf("%02d:%02d",ans/60,ans%60);
    }

}
