#include<stdio.h>

#define OK 1
#define ERROR 0
#define OVERFLOW -1
#define maxsize 100

typedef int elemtype;
typedef int status;

typedef struct
{
    int isbn;
    char name[100];
    float price;
}book;

typedef struct 
{
    book bookarry[maxsize];
    int length;
}booklist;

//判断是否为空
status isempty(booklist l)
{
    if(l.length==0)
    {
        return OK;
    }
    else
    {
        return ERROR;
    }
}


//取值
status getdata(booklist l,int i,book &e)//注意这里取的值是一个结构体类型的数组
{
    if(i<1||i>l.length)
    {
        return ERROR;
    }
    e=l.bookarry[i-1];
    return OK;
}


//获取表的长度
status listlength(booklist l)
{
    return l.length;
}

int main()
{
    booklist l;
    book e;
    int a,b,c;
    for(int i=0;i<3;i++)
    {
        scanf("%d", &l.bookarry[i].isbn);    // 输入 ISBN
        scanf("%s", l.bookarry[i].name);     // 输入 Name (单词，不能包含空格)
        scanf("%f", &l.bookarry[i].price);   // 输入 Price
    }
    a=getdata(l,1,e);
    b=listlength(l);
    c=isempty(l);
    //打印测试结果，看算法是否写错
    printf("isbn:%d  name:%s  price:%.2f",l.bookarry[1].isbn,l.bookarry[1].name,l.bookarry[1].price);
    printf("%d",b);
    printf("%d",c);
}